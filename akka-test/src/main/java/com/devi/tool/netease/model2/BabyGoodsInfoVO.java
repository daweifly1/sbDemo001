package com.devi.tool.netease.model2;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 宝贝计划商品的基本信息
 */
@Data
public class BabyGoodsInfoVO implements Serializable {

    private static final long serialVersionUID = 520212969787890931L;
    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品图片
     */
    private String imageUrl;

    /**
     * 十字描述
     */
    private String introduce;

    // 品牌名称
    private String brandName;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 当前价格
     */
    private BigDecimal currentPrice;

    // 商品利益点标签
    private List<String> interestLabels;

    private Integer minByNum;

    private List<String> skuIdList;
}
