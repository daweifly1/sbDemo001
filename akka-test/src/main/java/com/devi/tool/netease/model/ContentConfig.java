package com.devi.tool.netease.model;

import com.devi.tool.netease.CollumComment;
import lombok.Data;

import java.util.Date;

/**
 * 精选内容配置实体类
 * Created by hzchendawei on 2018/4/3.
 */
@Data
public class ContentConfig {
    @CollumComment(value = "主键")
    private Long id;

    @CollumComment(value = "类型", nullAble = false)
    private Integer type;

    @CollumComment(value = "链接", length = 1000)
    private String url;

    @CollumComment(value = "排序")
    private Long sort;

    @CollumComment(value = "状态：0未发布 1已上线", nullAble = false)
    private Integer status;

    @CollumComment(value = "创建人", length = 64)
    private String dbCreateAuthor;

    @CollumComment(value = "更新人", length = 64)
    private String dbUpdateAuthor;

    @CollumComment(value = "创建时间")
    private Date dbCreateTime;

    @CollumComment(value = "更新时间")
    private Date dbUpdateTime;

}
