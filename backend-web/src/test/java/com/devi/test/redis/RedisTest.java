package com.devi.test.redis;

import com.devi.test.SpringbootexampleApplicationTests;
import com.devi.test.domain.User;
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
    public void setVal() {
//        RedisUtils.set("springboottest111111", "中国式", 10000L);
//        User user = new User();
//        user.setName("测试");
//        user.setPhone("123444444444");
//        RedisUtils.set("springboottest", user, 10000L);
    }

    @Test
    public void getVal() throws InterruptedException {
        logger.info("init  val:" + userService.getUserById(1));
        int CONCURRENT_NUM = 100;
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
                long t = (long) (Math.random() * 4000);
                Thread.sleep(t);//每个client随机睡眠，为了充分测试refresh和load
                User u = userService.getUserById(1);
                logger.info(Thread.currentThread().getName() + ",val:" + u);
//                if (t % 13101 == 0) {
//                    u.setName(UUID.randomUUID().toString());
//                    userService.updateUserById(u);
//                }
                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}