package com.devi.test.redis;

import com.devi.test.SpringbootexampleApplicationTests;
import com.devi.test.domain.User;
import com.devi.test.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTest extends SpringbootexampleApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void setVal() {
//        RedisUtils.set("springboottest111111", "中国式", 10000L);
//        User user = new User();
//        user.setName("测试");
//        user.setPhone("123444444444");
//        RedisUtils.set("springboottest", user, 10000L);
    }

    @Test
    public void getVal() {
        User u = userService.getUserById(1);
        System.out.println("**************************" + u);

        Object o = RedisUtils.get("USER_ID_1");
        System.out.println("**************************" + o);
    }
}
