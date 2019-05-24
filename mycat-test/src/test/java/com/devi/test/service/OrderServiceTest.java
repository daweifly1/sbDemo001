package com.devi.test.service;

import com.devi.test.ApplicationTests;
import com.devi.test.beans.entity.OrderAddressDO;
import com.devi.test.beans.entity.OrderDO;
import com.devi.test.beans.entity.OrderItemDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @Package UserServiceTest
 * @Description: UserServiceTest
 * @Copyright: Copyright (c) 2016
 * @date 2017/5/12 17:21
 * version V1.0.0
 */
public class OrderServiceTest extends ApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void testSaveDouble() {
        for (int i = 10; i < 11; i++) {
            Long orderId = 0L + i;
            OrderDO order = genOrder(orderId);

            OrderAddressDO addr = genOrderAddress(orderId);
            OrderItemDO item = genOrderItemDO(orderId);
            int m = orderService.add(order, addr, item);

            System.out.println(m);
        }
    }

    private OrderItemDO genOrderItemDO(Long orderId) {
        OrderItemDO model = new OrderItemDO();
        model.setId(orderId);
        model.setOrderId(orderId);
        model.setGoodsId(1000L);
        model.setSkuId(1000L);
        model.setGoodsName("Tr8mV");
        model.setGoodsHeadImage("sHe9A");
        model.setGoodsAttr("UeQjt");
        model.setContent("aYAIp");
        model.setLinePrice(new BigDecimal(2));
        model.setGoodsPrice(new BigDecimal(1));
        model.setTotalNum(3);
        model.setTotalPrice(new BigDecimal(0));
        return model;
    }

    private OrderAddressDO genOrderAddress(Long orderId) {
        OrderAddressDO model = new OrderAddressDO();
        model.setId(orderId);
        model.setOrderId(orderId);
        model.setName("XM4JQ");
        model.setPhone("EVx35");
        model.setProvince("d85ga");
        model.setProvinceId(1003L);
        model.setCity("Y3R5r");
        model.setCityId(1002L);
        model.setRegion("eC6Kk");
        model.setRegionId(1002L);
        model.setDetail("xmZcD");
        model.setMemo("3rqf9");
        return model;
    }

    private OrderDO genOrder(long l) {
        OrderDO model = new OrderDO();
        model.setId(l);
        model.setOrderNo("JkRkm");
        model.setBuyerId(9527L);
        model.setMallId(9527L);
        model.setShopId(9527L);
        model.setTradeStatus(3);
        model.setPayStatus(1);
        Date current = new Date();
        model.setBestTime(current);
        model.setOrderTotalPrice(new BigDecimal(10));
        model.setCreditPrice(new BigDecimal(0));
        model.setPayPrice(new BigDecimal(0));
        model.setPayTime(current);
        model.setOutTradeNo("6cBGR");
        model.setRemark("OxoW5");
        model.setDeliveryStatus(0);
        model.setDeliveryTime(current);
        model.setDeliveryNo("w5gzK");
        model.setDbCreateTime(current);
        model.setDbUpdateAuthor("abKWP");
        model.setDbUpdateTime(current);
        return model;
    }

    @Test
    public void testqueryDouble() {
        Map<String, Object> m = orderService.queryMap();

        System.out.println(m);

        Map<String, Object> m2 = orderService.queryMap2();

        System.out.println(m2);
    }

}
