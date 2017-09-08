package com.devi.cache.interceptor;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by hzchendawei on 2017/9/8.
 */
@Aspect
@Component
public class GuavaLocalCacheAdvice {

    Map<String, LoadingCache<String, Object>> cacheMap = new HashMap<>();

    @Pointcut("@annotation(com.devi.cache.interceptor.GuavaLocalCache)")
    public void guavaLocalCache() {
    }

    @Around(value = "guavaLocalCache() && @annotation(localCache)")
    public Object cacheExcute(ProceedingJoinPoint pjp, GuavaLocalCache localCache) throws ExecutionException {
        String key = genKey(pjp, localCache);
        LoadingCache<String, Object> cache = getCacheFromCacheMap(localCache.group(), localCache, pjp);
        return cache.get(key);
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
                });
        return cache;
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
