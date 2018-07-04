package com.devi.tool.netease.model;

import com.devi.tool.netease.CollumComment;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Data
public class BabyImgConfig implements Serializable {
    @CollumComment(value = "主键")
    private Long id;

    @CollumComment(value = "类目id")
    private Long categoryId;

    @CollumComment(value = "类目名称,可以不入库")
    private String categoryName;

    @CollumComment(value = "各个年龄段图片配置信息")
    private String config;
    
    private List<BabyAgeImgItem> configList;


    @CollumComment(value = "数据创建时间")
    private Timestamp dbCreateTime;

    @CollumComment(value = "记录更新时间")
    private Timestamp dbUpdateTime;

    @CollumComment(value = "记录创建人")
    private String dbCreateAuthor;

    @CollumComment(value = "记录更新人")
    private String dbUpdateAuthor;
}
