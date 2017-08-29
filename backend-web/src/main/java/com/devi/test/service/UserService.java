package com.devi.test.service;

import com.devi.test.pagination.Page;
import com.devi.test.domain.User;
import com.devi.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Package UserService
 * @Description: UserService
 * @Copyright: Copyright (c) 2016
 *
 * @date 2017/5/12 15:30
 * version V1.0.0
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public Integer saveDouble(User user){
        userMapper.insert(user);
        user.setId(null);
        userMapper.insert(user);

        return user.getId();
    }


    public Integer save(User user){
        userMapper.insert(user);

        return user.getId();
    }


    public User getUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }


    public Page<User> queryPage(Integer pageNumber, Integer pageSize){
        Page<User> page = new Page<>(pageNumber, pageSize);
        userMapper.queryPage(page);
        return page;
    }
}
