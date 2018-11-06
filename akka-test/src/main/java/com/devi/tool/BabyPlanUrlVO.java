package com.devi.tool;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 宝贝计划页面的url
 */
@Data
@ToString
public class BabyPlanUrlVO implements Serializable {
    private static final long serialVersionUID = -8226397498459442075L;
    //主页，进入宝贝计划页面
    private String mainUrl;
    //添加编辑第1个宝贝地址
    private String edit0Url;

    //添加编辑第2个宝贝地址
    private String edit1Url;

    private BigDecimal n;
}
