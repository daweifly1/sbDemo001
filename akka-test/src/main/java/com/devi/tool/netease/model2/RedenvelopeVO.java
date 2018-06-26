package com.devi.tool.netease.model2;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by hzwangqiqing
 * on 2018/6/19.
 */
@Data
public class RedenvelopeVO implements Serializable {
    private static final long serialVersionUID = -3463126473178330389L;

    //优惠券方案号
    private Long couponSchemaId;

    //红包方案号前台id
    private String redEnvolpeFrontId;

    //总面额
    private BigDecimal couponAmount;

    //优惠券名称
    private String couponName;

    //优惠券的开始派发时间
    private Timestamp couponOpenTime;

    //优惠券的结束派发时间
    private Timestamp couponCloseTime;

    //优惠券生效时间
    private Timestamp couponActivtyTime;

    //优惠券失效时间
    private Timestamp couponExpireTime;

    //过期天数
    private Integer expireDays;

    //领取状态
    private Integer receiveStatus;

    //红包领取时间
    private Timestamp receiveTime;

    //幂等信息
    private String idempotent;

    //红包是否派发完毕
    private boolean dispatcherOver;
}