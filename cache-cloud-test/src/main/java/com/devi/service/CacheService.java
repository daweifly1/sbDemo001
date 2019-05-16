package com.devi.service;

import com.sohu.tv.builder.ClientBuilder;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

@Service
public class CacheService {

    private static final Long lockReleaseOK = 1L;
    static String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";// lua脚本，用来释放分布式锁

    static JedisPool jedisPool;


    public static void main(String[] args) {
        long appId = 10000;
// 使用默认配置
//jedisPool = ClientBuilder.redisStandalone(appId).build();
/**
 * 使用自定义配置
 */
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        jedisPool = ClientBuilder.redisStandalone(appId)
                .setTimeout(2000)
                .setPoolConfig(poolConfig)
                .build();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("key1", "3");
            System.out.println(jedis.get("key1"));

            String key = "xgit_1";

            System.out.println("准备获取分布式锁");
            String uuid = UUID.randomUUID().toString();
            boolean r = lock(key, uuid, 200);
            System.out.println("r:" + r);

            boolean release = releaseLock(key, uuid);
            System.out.println("release:" + release);

            for (int i = 0; i < 100; i++) {
                Object o = limiter("wwww", 10, 3);
                System.out.println(i + "  :   " + o);
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }

    public static boolean lock(String key, String lockValue, int expire) {
        if (null == key) {
            return false;
        }
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String res = jedis.set(key, lockValue, "NX", "EX", expire);
            return res != null && res.equals("OK");
        } catch (Exception e) {
            return false;
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    /**
     * 获取一个分布式锁 , 超时则返回失败
     *
     * @param key       锁的key
     * @param lockValue 锁的value
     * @param timeout   获取锁的等待时间，单位为 秒
     * @return 获锁成功 - true | 获锁失败 - false
     */
    public static boolean tryLock(String key, String lockValue, int timeout, int expire) {
        final long start = System.currentTimeMillis();
        int expiredNx = 1000;
        if (timeout > expiredNx) {
            timeout = expiredNx;
        }
        final long end = start + timeout * 1000;
        boolean res = false; // 默认返回失败
        while (!(res = lock(key, lockValue, expire))) { // 调用了上面的 lock方法
            if (System.currentTimeMillis() > end) {
                break;
            }
        }
        return res;
    }

    public static boolean releaseLock(String key, String lockValue) {
        if (key == null || lockValue == null) {
            return false;
        }
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Object res = jedis.eval(luaScript, Collections.singletonList(key), Collections.singletonList(lockValue));
            return res != null && res.equals(lockReleaseOK);
        } catch (Exception e) {
            return false;
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }


    /**
     * 每perTime秒最多访问times次
     *
     * @param ip
     * @param perTime
     * @param times
     * @return
     */
    public static boolean limiter(String ip, int perTime, int times) {
        Jedis jedis = null;
        try {
            String lua = "local num = redis.call('incr', KEYS[1])\n" +
                    "if tonumber(num) == 1 then\n" +
                    "\tredis.call('expire', KEYS[1], ARGV[1])\n" +
                    "\treturn 1\n" +
                    "elseif tonumber(num) > tonumber(ARGV[2]) then\n" +
                    "\treturn 0\n" +
                    "else \n" +
                    "\treturn 1\n" +
                    "end\n";
            jedis = jedisPool.getResource();
            Object result = jedis.evalsha(jedis.scriptLoad(lua), Arrays.asList(ip), Arrays.asList(perTime + "", times + ""));
            if (null != result && "1".equals(result.toString())) {
                return true;
            }
            return false;
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

}
