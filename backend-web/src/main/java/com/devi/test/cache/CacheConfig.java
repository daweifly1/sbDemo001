package com.devi.test.cache;

import com.devi.test.redis.RedisUtils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCachePrefix;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by hzchendawei on 2017/9/6.
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

//    /**
//     * 创建基于guava的Cache Manager
//     *
//     * @return
//     */
//    @Bean
//    public CacheManager guavaCacheManager() {
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//
//        //把各个cache注册到cacheManager中，GuavaCache实现了org.springframework.cache.Cache接口
//        ArrayList<GuavaCache> caches = new ArrayList<GuavaCache>();
//        for (Caches c : Caches.values()) {
//            caches.add(
//                    new GuavaCache(c.name(),
//                            CacheBuilder.newBuilder().recordStats().expireAfterWrite(c.getExpireTime(), TimeUnit.SECONDS).maximumSize(c.getMaxSize())
//                                    .build()
//                    ));
//        }
//
//
////        cache = CacheBuilder.newBuilder()
////                .maximumSize(100)
////                .expireAfterWrite(60, TimeUnit.SECONDS)
////                .refreshAfterWrite(30, TimeUnit.SECONDS)
////                .build(new CacheLoader<String, List<SearchHotlistsDto>>() {
////                    @Override
////                    public List<SearchHotlistsDto> load(String key) throws Exception {
////                        return queryPcKoutHotlistsFromLocalCache(key);
////                    }
////
////                    @Override
////                    public ListenableFuture<List<SearchHotlistsDto>> reload(String key, List<SearchHotlistsDto> oldValue) throws Exception {
////                        return Futures.immediateFuture(queryPcKoutHotlistsFromLocalCache(key));
////
////                    }
////                });
//
//        cacheManager.setCaches(caches);
//        return cacheManager;
//    }

    /**
     * RedisTemplate配置
     *
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(factory);
        // 开启事务支持
        redisTemplate.setEnableTransactionSupport(false);
        // 使用String格式序列化缓存键
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // 设置缓存
        RedisUtils.setRedisTemplate(redisTemplate);

        return redisTemplate;
    }

    /**
     * 创建基于redis的Cache Manager
     *
     * @return
     */
    @Bean
    @Primary
    public CacheManager redisCacheManager(RedisTemplate redisTemplate) {
        JdkSerializationRedisSerializer jackson2JsonRedisSerializer = new JdkSerializationRedisSerializer();
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate, Arrays.asList("ELEMENT_COMMON2", "ELEMENT_COMMON"), true);
        cacheManager.setCachePrefix(new RedisCachePrefix() {
            @Override
            public byte[] prefix(String cacheName) {
                return "element_".getBytes();
            }
        });
        cacheManager.setDefaultExpiration(300);//秒
        return cacheManager;
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
}
