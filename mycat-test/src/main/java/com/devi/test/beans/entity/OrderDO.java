package com.devi.test.beans.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息 DO
 */
@Data
@ToString
public class OrderDO implements Serializable {
    private static final long serialVersionUID = -1L;
    //主键,数据库必填字段
    private Long id;
    //订单号，唯一,数据库必填字段
    private String orderNo;
    //买家ID,数据库必填字段
    private Long buyerId;
    //商家ID,数据库必填字段
    private Long mallId;
    //店铺ID,数据库必填字段
    private Long shopId;
    //交易状态，0进行中，1,已完成，2取消支付，3已结算,数据库必填字段
    private Integer tradeStatus;
    //支付状态，0未付款，1,已付款，2线下付款，3线下付款已收款,数据库必填字段
    private Integer payStatus;
    //收货人的最佳收货时间
    private Date bestTime;
    //订单总金额，所有商品金额减去“减免金额”
    private BigDecimal orderTotalPrice;
    //减免金额,默认0
    private BigDecimal creditPrice;
    //付款金额
    private BigDecimal payPrice;
    //订单支付时间
    private Date payTime;
    //交易订单号,数据库必填字段
    private String outTradeNo;
    //用户备注
    private String remark;
    //发货状态，0未发货，2,已发货，3已签收,数据库必填字段
    private Integer deliveryStatus;
    //发货时间
    private Date deliveryTime;
    //发货单号
    private String deliveryNo;
    //创建时间,数据库必填字段
    private Date dbCreateTime;
    //更新人
    private String dbUpdateAuthor;
    //更新时间
    private Date dbUpdateTime;

}
