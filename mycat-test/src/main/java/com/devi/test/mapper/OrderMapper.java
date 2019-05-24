package com.devi.test.mapper;

import com.devi.test.beans.entity.OrderDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 订单信息 Mapper
 */
@Mapper
public interface OrderMapper {

    List<OrderDO> queryList(Map<String, Object> condition);

    int insert(OrderDO model);

    int batchInsert(List<OrderDO> list);

    int deleteByPrimaryKeySelective(Long id);

    int updateByPrimaryKeySelective(OrderDO bean);
}
