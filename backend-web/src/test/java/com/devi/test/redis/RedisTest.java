package com.devi.test.redis;

import com.devi.test.SpringbootexampleApplicationTests;
import com.devi.test.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class RedisTest extends SpringbootexampleApplicationTests {

    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(RedisTest.class);


    @Test
    public void testGuavaLocalCache() throws InterruptedException {
        Integer m = userService.queryTestLocalCache(1);
        logger.info(Thread.currentThread().getName() + "    ====,{}", m);
        int CONCURRENT_NUM = 1000;
        CyclicBarrier barrier = new CyclicBarrier(CONCURRENT_NUM);
        CountDownLatch latch = new CountDownLatch(CONCURRENT_NUM);
        for (int i = 0; i < CONCURRENT_NUM; i++) {
            final ClientRunnable runnable = new ClientRunnable(barrier, latch);
            Thread thread = new Thread(runnable, "client-" + i);
            thread.start();
        }

        //测试一段时间不访问后是否执行expire而不是refresh
        latch.await();
        Thread.sleep(5100L);
        logger.info("\n超过expire时间未读之后...");

        m = userService.queryTestLocalCache(1);
        logger.info(Thread.currentThread().getName() + "    ====,{}", m);
    }


    @Test
    public void testEvictRedisCache() {
        userService.evictUserRedis2();
    }

    @Test
    public void testRedisCache() {
//        User u = userService.getUserByIdRedis(1);
//        logger.info("1====================init  val:" + userService.updateUserByIdRedis(u));

        logger.info("getUserByIdRedis2====================init  val:" + userService.getUserByIdRedis2(8));
//        logger.info("getUserByIdRedis2====================init  val:" + userService.getUserByIdRedis2(2));
//        logger.info("getUserByIdRedis2====================init  val:" + userService.getUserByIdRedis2(1));
//        logger.info("getUserByIdRedis2====================init  val:" + userService.getUserByIdRedis2(2));

//        //query key
//        logger.info("1====================init  val:" + userService.getUserByIdRedis(1));
//
//        logger.info("1   ====================init  val:" + userService.getUserByIdRedis2(1));
//
//        userService.evictUserRedis();
//        logger.info("2====================init  val:" + userService.getUserByIdRedis2(1));
//
//
//        logger.info("3====================init  val:" + userService.getUserByIdRedis2(1));
//
//        userService.evictUserRedis();
//        logger.info("4====================init  val:" + userService.getUserByIdRedis2(1));

//        userService.evictUserRedis();
//        Object o = RedisUtils.get("USER_ID_1");
//        logger.info("o val:" + o);
//
//        User u = userService.getUserByIdRedis(1);
//        logger.info("2 val:" + u);
//        u.setName(UUID.randomUUID().toString());
//        userService.updateUserByIdRedis(u);
//        logger.info("3 val:" + userService.getUserByIdRedis(1));
//
//        o = RedisUtils.get("USER_ID_1");
//        logger.info("o val:" + o);
    }

    @Test
    public void getVal() throws InterruptedException {
        logger.info("init  val:" + userService.getUserById(1));
        int CONCURRENT_NUM = 10000;
        CyclicBarrier barrier = new CyclicBarrier(CONCURRENT_NUM);
        CountDownLatch latch = new CountDownLatch(CONCURRENT_NUM);
        for (int i = 0; i < CONCURRENT_NUM; i++) {
            final ClientRunnable runnable = new ClientRunnable(barrier, latch);
            Thread thread = new Thread(runnable, "client-" + i);
            thread.start();
        }

        //测试一段时间不访问后是否执行expire而不是refresh
        latch.await();
        Thread.sleep(5100L);
        logger.info("\n超过expire时间未读之后...");


        logger.info("pre stop  val:" + userService.getUserById(1));
    }

    private class ClientRunnable implements Runnable {

        CyclicBarrier barrier;
        CountDownLatch latch;

        public ClientRunnable(CyclicBarrier barrier, CountDownLatch latch) {
            this.barrier = barrier;
            this.latch = latch;
        }

        public void run() {
            try {
                barrier.await();
                long t = (long) (3000);
                Thread.sleep(t);//每个client随机睡眠，为了充分测试refresh和load
//                User u = userService.getUserById(1);
//                logger.info(Thread.currentThread().getName() + ",val:" + u);
//                if (t % 13101 == 0) {
//                    u.setName(UUID.randomUUID().toString());
//                    userService.updateUserById(u);
//                }
                Integer m = userService.queryTestLocalCache(1);
                logger.info(Thread.currentThread().getName() + "    m===={}", m);
                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
