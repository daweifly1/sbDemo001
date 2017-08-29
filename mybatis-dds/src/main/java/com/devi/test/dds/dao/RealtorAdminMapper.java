package com.devi.test.dds.dao;

import com.devi.test.dds.domain.RealtorAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtorAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RealtorAdmin record);

    int insertSelective(RealtorAdmin record);

    RealtorAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RealtorAdmin record);

    int updateByPrimaryKey(RealtorAdmin record);
}