package com.devi.tool.netease.model;

import com.devi.tool.netease.CollumComment;
import lombok.Data;

import java.io.Serializable;

/**
 * 宝贝成长标准
 */
@Data
public class BabyGrowthStd implements Serializable {
    @CollumComment(value = "主键")
    private Long id;

    @CollumComment(value = "月龄")
    private Integer month;


    @CollumComment(value = "性别")
    private Integer gender;

    @CollumComment(value = "最小身高")
    private String minLen;

    @CollumComment(value = "最大身高")
    private String maxLen;

    @CollumComment(value = "最小体重")
    private String minWeight;

    @CollumComment(value = "最大体重")
    private String maxWeight;
}
