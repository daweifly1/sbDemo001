package com.devi.test.mapper;

import com.devi.test.beans.entity.OrderItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 订单详情信息 Mapper
 */
@Mapper
public interface OrderItemMapper {

    List<OrderItemDO> queryList(Map<String, Object> condition);

    int insert(OrderItemDO model);

    int batchInsert(List<OrderItemDO> list);

    int updateByPrimaryKeySelective(OrderItemDO bean);

    int deleteByPrimaryKeySelective(Long id);

}
