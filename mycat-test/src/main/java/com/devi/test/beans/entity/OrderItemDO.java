package com.devi.test.beans.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单详情信息 DO
 */
@Data
@ToString
public class OrderItemDO implements Serializable {
    private static final long serialVersionUID = -1L;
    //主键,数据库必填字段
    private Long id;
    //订单ID,数据库必填字段
    private Long orderId;
    //商品ID,数据库必填字段
    private Long goodsId;
    //商品SKU ID,数据库必填字段
    private Long skuId;
    //商品名称
    private String goodsName;
    //商品头图
    private String goodsHeadImage;
    //商品属性信息
    private String goodsAttr;
    //商品内容
    private String content;
    //划线价格
    private BigDecimal linePrice;
    //购买价格
    private BigDecimal goodsPrice;
    //购买数量
    private Integer totalNum;
    //总金额
    private BigDecimal totalPrice;

}
