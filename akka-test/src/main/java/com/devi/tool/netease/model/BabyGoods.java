package com.devi.tool.netease.model;

import com.devi.tool.netease.CollumComment;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 宝贝计划中商品集合
 */
@Data
public class BabyGoods implements Serializable {
    @CollumComment(value = "主键")
    private Long id;

    @CollumComment(value = "后台类目id")
    private Long categoryId;

    @CollumComment(value = "年龄区间")
    private Integer ageRange;

    @CollumComment(value = "性别")
    private Integer gender;

    @CollumComment(value = "关键词")
    private String keyWords;

    @CollumComment(value = "商品ID集合的json")
    private String goodsIdListJson;

    @CollumComment(value = "记录更新时间")
    private Timestamp dbUpdateTime;

}
