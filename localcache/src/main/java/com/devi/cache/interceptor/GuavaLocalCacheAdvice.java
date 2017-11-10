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

    Map<String, LoadingCache<String, Object>> cacheMap = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.devi.cache.interceptor.GuavaLocalCache)")
    public void guavaLocalCache() {
    }

    @Around(value = "guavaLocalCache() && @annotation(localCache)")
    public Object cacheExcute(ProceedingJoinPoint pjp, GuavaLocalCache localCache) throws ExecutionException {
//        String key = genKey(pjp, localCache);
        try {
            Method method = getMethod(pjp);
            final String key = parseKey(localCache.preFix(), localCache.keyExt(), method, pjp.getArgs());

            LoadingCache<String, Object> cache = getCacheFromCacheMap(localCache.group(), localCache, pjp);
            return cache.get(key);
        } catch (Exception e) {
            logger.warn("cacheExcute error .", e);
        }
        return null;
    }

    private LoadingCache<String, Object> getCacheFromCacheMap(String group, GuavaLocalCache localCache, final ProceedingJoinPoint pjp) {
        LoadingCache<String, Object> cache = cacheMap.get(group);
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
                            return pjp.proceed();
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    public ListenableFuture<Object> reload(String key, Object oldValue) throws Exception {
                        return super.reload(key, oldValue);
                    }
                });
        cacheMap.put(group, cache);
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
            //SPEL上下文
            StandardEvaluationContext context = new StandardEvaluationContext();
            //把方法参数放入SPEL上下文中
            for (int i = 0; i < paraNameArr.length; i++) {
                context.setVariable(paraNameArr[i], args[i]);
            }
            //使用SPEL进行key的解析
            return sb.append(parser.parseExpression(keyExt).getValue(context, String.class)).toString();
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


}
