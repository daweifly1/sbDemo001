package com.devi.tool.netease.model;

import com.devi.tool.netease.CollumComment;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class BabyArticleConfig implements Serializable {
    @CollumComment(value = "主键")
    private Long id;

    @CollumComment(value = "长文id")
    private Long articleId;


    @CollumComment(value = "排序")
    private Long sort;

    @CollumComment(value = "数据创建时间")
    private Timestamp dbCreateTime;

    @CollumComment(value = "记录更新时间")
    private Timestamp dbUpdateTime;

    @CollumComment(value = "记录创建人")
    private String dbCreateAuthor;

    @CollumComment(value = "记录更新人")
    private String dbUpdateAuthor;
}
