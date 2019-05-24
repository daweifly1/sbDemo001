package com.devi.test.mapper;

import com.devi.test.beans.entity.OrderAddressDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 订单地址信息 Mapper
 */
@Mapper
public interface OrderAddressMapper {

    List<OrderAddressDO> queryList(Map<String, Object> condition);

    int insert(OrderAddressDO model);

    int batchInsert(List<OrderAddressDO> list);

    int updateByPrimaryKeySelective(OrderAddressDO bean);

    int deleteByPrimaryKeySelective(Long id);
}
