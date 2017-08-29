package com.devi.test.mapper;

import com.devi.test.pagination.Page;
import com.devi.test.domain.User;

import java.util.List;

/**
 * @Package: UserMapper.java
 * @Description: InnoDB free: 4096 kB
 * @Copyright: Copyright (c) 2017
 * All right reserved.
 * Author jon lv
 * @date 2017/05/12 15:24
 * version v1.0.0
 */
//@Mapper
public interface UserMapper {
    /**
     * @param id
     * @return int
     * @throws []
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author jon lv
     * @Date 2017/05/12 15:24
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return int
     * @throws []
     * @Description: 插入数据库记录
     * @Title insert
     * @Author jon lv
     * @Date 2017/05/12 15:24
     */
    int insert(User record);

    /**
     * @param record
     * @return int
     * @throws []
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author jon lv
     * @Date 2017/05/12 15:24
     */
    int insertSelective(User record);

    /**
     * @param id
     * @return User
     * @throws []
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author jon lv
     * @Date 2017/05/12 15:24
     */
    User selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @return int
     * @throws []
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author jon lv
     * @Date 2017/05/12 15:24
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * @param record
     * @return int
     * @throws []
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author jon lv
     * @Date 2017/05/12 15:24
     */
    int updateByPrimaryKey(User record);

    List<User> queryPage(Page<User> page);
}