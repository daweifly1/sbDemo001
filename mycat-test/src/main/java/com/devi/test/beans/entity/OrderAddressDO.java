package com.devi.test.beans.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 订单地址信息 DO
 */
@Data
@ToString
public class OrderAddressDO implements Serializable {
    private static final long serialVersionUID = -1L;
    //主键,数据库必填字段
    private Long id;
    //订单ID,数据库必填字段
    private Long orderId;
    //收件人姓名
    private String name;
    //收件人电话
    private String phone;
    //省
    private String province;
    //省ID
    private Long provinceId;
    //市
    private String city;
    //市ID
    private Long cityId;
    //区、县
    private String region;
    //区、县 ID
    private Long regionId;
    //详细地址
    private String detail;
    //其他备注
    private String memo;

}
