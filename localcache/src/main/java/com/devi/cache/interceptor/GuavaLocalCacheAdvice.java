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

    Map<String, HitInfo> calcMap = new ConcurrentHashMap<>(100);

    Map<String, LoadingCache<String, Object>> cacheMap = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.devi.cache.interceptor.GuavaLocalCache)")
    public void guavaLocalCache() {
    }

    @Around(value = "guavaLocalCache() && @annotation(localCache)")
    public Object cacheExcute(ProceedingJoinPoint pjp, GuavaLocalCache localCache) throws ExecutionException {
//        String key = genKey(pjp, localCache);
        try {
            Method method = getMethod(pjp);
            String key = localCache.group() + parseKey(localCache.preFix(), localCache.keyExt(), method, pjp.getArgs());
            LoadingCache<String, Object> cache = getCacheFromCacheMap(key, pjp, localCache);
            HitInfo hh = calcMap.get(key);
            if (null == hh) {
                hh = new HitInfo();
                calcMap.put(key, hh);
            }
            hh.TotalPlusOne();
            Object o = cache.get(key);
            if (o == nullObject) {
                hh.MisPlusOne();
                return null;
            } else {
                hh.HitPlusOne();
            }
            logger.info("{}:命中情况：{}", key, hh);
            return o;
        } catch (Exception e) {
            logger.warn("cacheExcute error .", e);
        }
        return null;
    }

    private LoadingCache<String, Object> getCacheFromCacheMap(final String fkey, final ProceedingJoinPoint pjp, final GuavaLocalCache localCache) {
        LoadingCache<String, Object> cache = cacheMap.get(fkey);
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
                        try {
                            long t = System.currentTimeMillis();
                            logger.info("begin local cach,key {}", key);
                            Object o = pjp.proceed();
                            logger.info("end local cach,key {} ,time:{}", key, System.currentTimeMillis() - t);
                            if (localCache.nullAble() && null == o) {
                                return nullObject;
                            }
                            return o;
                        } catch (Throwable throwable) {
                            logger.warn("getCacheFromCacheMap error .{}", throwable.getMessage());
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
        volatile int hitCount;
        volatile int totalCount;
        volatile int missCount;

        public void HitPlusOne() {
            this.hitCount++;
        }

        public void MisPlusOne() {
            this.missCount++;
        }

        public void TotalPlusOne() {
            this.totalCount++;
        }

        public int getHitCount() {
            return this.hitCount;
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
                radio = new BigDecimal(hitCount).divide(new BigDecimal(totalCount));
            }
            return "HitInfo{" +
                    "hitCount=" + hitCount +
                    ", totalCount=" + totalCount +
                    ", missCount=" + missCount +
                    ",命中率：" + radio +
                    '}';
        }
    }

}
