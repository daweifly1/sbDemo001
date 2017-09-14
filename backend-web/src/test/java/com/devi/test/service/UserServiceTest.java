package com.devi.test.service;

import com.devi.test.pagination.Page;
import com.devi.test.SpringbootexampleApplicationTests;
import com.devi.test.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package UserServiceTest
 * @Description: UserServiceTest
 * @Copyright: Copyright (c) 2016
 *
 * @date 2017/5/12 17:21
 * version V1.0.0
 */
public class UserServiceTest extends SpringbootexampleApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserService2 userService2;

    @Test
    public void testSaveDouble(){
        User user = new User();
        user.setHead("testSaveDouble");
        user.setName("testSaveDouble");
        userService2.saveDouble(user);

        System.out.println(user);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setHead("test world");
        user.setName("test world");
        userService.save(user);
        System.out.println(user);
    }

    @Test
    public void testQueryPage(){
        Page<User> page = userService.queryPage(1,2);
        System.out.println(page);
    }

    @Test
    public void testGetOne(){
        User user = userService.getUserById(82006);
        System.out.println(user);
    }
}
