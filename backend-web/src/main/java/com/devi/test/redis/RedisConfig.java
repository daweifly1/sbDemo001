//package com.devi.test.redis;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.cache.CacheBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.concurrent.ConcurrentMapCache;
//import org.springframework.cache.guava.GuavaCache;
//import org.springframework.cache.guava.GuavaCacheManager;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.cache.support.SimpleCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Package RedisConfig
// * @Description: RedisConfig
// * @Copyright: Copyright (c) 2016
// * @date 2017/5/18 13:58
// * version V1.0.0
// */
//@Configuration
//@EnableCaching
//public class RedisConfig extends CachingConfigurerSupport {
//
//    public static final String GUAVA_KEY = "guavaCache";  //cache key
//    @Value("${cache.guavaCache.maxSize}")
//    private long guavaCacheMaxSize;
//    @Value("${cache.guavaCache.duration}")
//    private long guavaCacheDuration;
//
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(target.getClass().getName());
//                sb.append(method.getName());
//                for (Object obj : params) {
//                    sb.append(obj.toString());
//                }
//                return sb.toString();
//            }
//        };
//    }
//
//    /**
//     * RedisTemplate配置
//     *
//     * @return
//     */
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
//        redisTemplate.setConnectionFactory(factory);
//        // 开启事务支持
//        redisTemplate.setEnableTransactionSupport(false);
//        // 使用String格式序列化缓存键
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//
//        // 设置缓存
//        RedisUtils.setRedisTemplate(redisTemplate);
//
//        return redisTemplate;
//    }
//
//    /**
//     * 管理缓存
//     * 设置缓存对象的序列化方式,不设置会报错
//     * 另外对于json序列化,对象要提供默认空构造器
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean
//    @Primary
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        cacheManager.setDefaultExpiration(300);//秒
//
//        return cacheManager;
//    }
//
//
////    @Bean(name = "localCacheManager")
////    public CacheManager localCacheManager() {
////        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
////        List<Cache> caches = new ArrayList<>();
////        caches.add(new ConcurrentMapCache("localCache"));
//////        caches.add(buildGuavaCache());
//////        simpleCacheManager.setCaches(caches);
////        return simpleCacheManager;
////    }
//
//
//    @Bean(name = "guavaCacheManager")
//    public CacheManager guavaCacheManager() {
//        GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
//        return guavaCacheManager;
//    }
//
//
////    @Bean
////    public CacheManager compositeCacheManager() {
////        CompositeCacheManager compositeCacheManager=new CompositeCacheManager();
////        compositeCacheManager.setFallbackToNoOpCache(true);
////        List<CacheManager> cacheManagerList=new ArrayList<>();
////        cacheManagerList.add(localCacheManager());
////        cacheManagerList.add(cacheManager(redisTemplate()));
////
////        return simpleCacheManager;
////    }
////
//
//
//    private GuavaCache buildGuavaCache() {
//        return new GuavaCache(GUAVA_KEY,
//                CacheBuilder.newBuilder()
//                        .recordStats()
//                        .maximumSize(guavaCacheMaxSize)
//                        .expireAfterWrite(guavaCacheDuration, TimeUnit.SECONDS)
//                        .build());
//    }
//}
