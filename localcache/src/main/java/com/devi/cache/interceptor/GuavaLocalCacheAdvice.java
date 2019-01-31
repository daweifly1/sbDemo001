package com.devi.cache.interceptor;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by hzchendawei on 2017/9/8.
 */
@Aspect
@Component
public class GuavaLocalCacheAdvice {
    private Logger logger = LoggerFactory.getLogger(GuavaLocalCacheAdvice.class);

    private ExpressionParser parser = new SpelExpressionParser();

    private Object nullObject = new Object();

    //统计命中率最多保留数量，可以考虑配置
    private Integer MAX_STATICS = 10000;

    Map<String, HitInfo> calcMap = new HashMap<>(MAX_STATICS);

    Map<String, LoadingCache<String, Object>> cacheMap = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.devi.cache.interceptor.GuavaLocalCache)")
    public void guavaLocalCache() {
    }

    @Around(value = "guavaLocalCache() && @annotation(localCache)")
    public Object cacheExcute(ProceedingJoinPoint pjp, GuavaLocalCache localCache) throws ExecutionException {
//        String key = genKey(pjp, localCache);
        try {
            Method method = getMethod(pjp);
            String key = parseKey(localCache.preFix(), localCache.keyExt(), method, pjp.getArgs());
            LoadingCache<String, Object> cache = getCacheFromCacheMap(key, pjp, localCache);
            Object o = cache.get(key);
            if (o == nullObject) {
                return null;
            }
            return o;
        } catch (Exception e) {
            logger.warn("cacheExcute error .", e);
        }
        return null;
    }

    private LoadingCache<String, Object> getCacheFromCacheMap(String ffkey, final ProceedingJoinPoint pjp, final GuavaLocalCache localCache) {
        final String gname = localCache.group();
        final String fkey = gname + "_" + ffkey;
        LoadingCache<String, Object> cache = cacheMap.get(fkey);
        totalCount(fkey);
        if (null != cache) {
            return cache;
        }
        cache = CacheBuilder.newBuilder()
                .maximumSize(localCache.maxSize())
                .expireAfterWrite(localCache.expireTime(), TimeUnit.SECONDS)
                .refreshAfterWrite(localCache.refreshTime(), TimeUnit.SECONDS)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) {
                        long t = System.currentTimeMillis();
                        try {
                            //未命中统计
                            missCount(fkey);
                            Object o = pjp.proceed();
                            if (localCache.nullAble() && null == o) {
                                return nullObject;
                            }
                            return o;
                        } catch (Throwable throwable) {
                            logger.warn("getCacheFromCacheMap error .{}", throwable.getMessage());
                        } finally {
                            logger.info("query localCache by key {} ,time:{}", key, System.currentTimeMillis() - t);
                        }
                        return null;
                    }

                    @Override
                    public ListenableFuture<Object> reload(String key, Object oldValue) throws Exception {
                        return super.reload(key, oldValue);
                    }
                });
        cacheMap.put(fkey, cache);
        return cache;
    }

    private void totalCount(String fkey) {
        if (MAX_STATICS < 0) {
            return;
        }
        synchronized (fkey) {
            try {
                HitInfo hh = calcMap.get(fkey);
                if (null == hh) {
                    hh = new HitInfo();
                    if (cacheMap.size() >= MAX_STATICS) {
                        //若统计命中率的的key过大清空重新统计
                        cacheMap.clear();
                    }
                    calcMap.put(fkey, hh);
                }
                hh.TotalPlusOne();
                logHitInfo(fkey, hh);
            } catch (Exception e) {
                logger.error("fkey:{}", fkey, e);
            }
        }
    }

    private void missCount(String fkey) {
        if (MAX_STATICS < 0) {
            return;
        }
        synchronized (fkey) {
            try {
                HitInfo hh2 = calcMap.get(fkey);
                if (null == hh2) {
                    hh2 = new HitInfo();
                }
                hh2.MisPlusOne();
                logHitInfo(fkey, hh2);
            } catch (Exception e) {
                logger.error("fkey:{}", fkey, e);
            }
        }
    }

    public void clearCache(String gname) {
        if (cacheMap.isEmpty()) {
            return;
        }
        for (String key : cacheMap.keySet()) {
            if (key.startsWith(gname)) {
                cacheMap.put(key, null);
            }
        }
    }

    public void clearAllCache() {
        cacheMap.clear();
    }

    private void logHitInfo(String fkey, HitInfo hh) {
        try {
            logger.info("{}:命中情况：{}", fkey, hh);
        } catch (Exception e) {
            logger.error("logHitInfo error", e);
        }
    }


    /**
     * 获取缓存的key
     * key 缓存key前缀
     * keyExt 具体参数，支持SPEL表达式
     *
     * @return
     */

    private String parseKey(String pre, String keyExt, Method method, Object[] args) {
        if (null == pre) {
            pre = "";
        }
        if (null == keyExt) {
            return pre;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pre);
        try {
            //获取被拦截方法参数名列表(使用Spring支持类库)
            LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
            String[] paraNameArr = u.getParameterNames(method);
            if (null != paraNameArr && paraNameArr.length > 0) {
                //SPEL上下文
                StandardEvaluationContext context = new StandardEvaluationContext();
                //把方法参数放入SPEL上下文中
                for (int i = 0; i < paraNameArr.length; i++) {
                    context.setVariable(paraNameArr[i], args[i]);
                }
                //使用SPEL进行key的解析
                return sb.append(parser.parseExpression(keyExt).getValue(context, String.class)).toString();
            } else {
                return sb.toString();
            }
        } catch (Exception e) {
            logger.warn("[RedisCacheableAopSupport] parseKey error", e);
        }
        return sb.toString();
    }

    /**
     * 获取被拦截方法对象
     * <p/>
     * MethodSignature.getMethod() 获取的是顶层接口或者父类的方法对象
     * 而缓存的注解在实现类的方法上
     * 所以应该使用反射获取当前对象的方法对象
     */
    public Method getMethod(ProceedingJoinPoint pjp) {
        //获取参数的类型
        Class[] argTypes = ((MethodSignature) pjp.getSignature()).getMethod().getParameterTypes();

        Method method = null;
        try {
            method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return method;

    }


    private String genKey(ProceedingJoinPoint pjp, GuavaLocalCache localCache) {
        StringBuilder sb = new StringBuilder();
        sb.append(localCache.preFix());
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Object[] paraObject = pjp.getArgs();
        if (null != method) {
            sb.append(method.getName());
        }
        if (null != paraObject) {
            for (Object o : paraObject) {
                sb.append(o.toString());
            }
        }
        return sb.toString();
    }


    class HitInfo {
        volatile int totalCount;
        volatile int missCount;

        public void MisPlusOne() {
            this.missCount++;
        }

        public void TotalPlusOne() {
            this.totalCount++;
        }

        public int getTotalCount() {
            return this.totalCount;
        }


        public int getMissCount() {
            return this.missCount;
        }


        @Override
        public String toString() {
            BigDecimal radio = BigDecimal.ZERO;
            if (totalCount > 0) {
                radio = (new BigDecimal(totalCount).subtract(new BigDecimal(missCount))).divide(new BigDecimal(totalCount), 5, 5);
            }
            return "HitInfo{" +
                    "totalCount=" + totalCount +
                    ", missCount=" + missCount +
                    ",命中率：" + radio +
                    ",TotalMemory:" + Runtime.getRuntime().totalMemory() / (1024 * 1024) + "M" +
                    ",FreeMemory:" + Runtime.getRuntime().freeMemory() / (1024 * 1024) + "M" +
                    '}';
        }
    }

}
