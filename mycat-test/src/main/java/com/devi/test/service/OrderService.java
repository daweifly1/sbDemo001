package com.devi.test.service;

import com.devi.test.beans.entity.OrderAddressDO;
import com.devi.test.beans.entity.OrderDO;
import com.devi.test.beans.entity.OrderItemDO;
import com.devi.test.mapper.OrderAddressMapper;
import com.devi.test.mapper.OrderItemMapper;
import com.devi.test.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Order 后台接口实现类
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderAddressMapper orderAddressMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Transactional
    public Map<String, Object> queryMap() {
        Map<String, Object> r = new HashMap<String, Object>();
        r.put("orderMapper", orderMapper.queryList(null));
//        r.put("orderAddressMapper", orderAddressMapper.queryList(null));
//        r.put("orderItemMapper", orderItemMapper.queryList(null));
        return r;
    }

    public Map<String, Object> queryMap2() {
        Map<String, Object> r = new HashMap<String, Object>();
        r.put("orderMapper", orderMapper.queryList(null));
//        r.put("orderAddressMapper", orderAddressMapper.queryList(null));
//        r.put("orderItemMapper", orderItemMapper.queryList(null));
        return r;
    }

    @Transactional
    public int add(OrderDO order, OrderAddressDO orderAddress, OrderItemDO orderItem) {
        int r = 0;
        r += orderMapper.insert(order);
        r += orderAddressMapper.insert(orderAddress);
//        if (order != null) {
//            throw new RuntimeException("hhh");
//        }
        r += orderItemMapper.insert(orderItem);
        return r;
    }

    @Transactional
    public int update(OrderDO order, OrderAddressDO orderAddress, OrderItemDO orderItem) {
        int r = 0;
        r += orderMapper.updateByPrimaryKeySelective(order);
        r += orderAddressMapper.updateByPrimaryKeySelective(orderAddress);
        r += orderItemMapper.updateByPrimaryKeySelective(orderItem);
        return r;
    }


}
