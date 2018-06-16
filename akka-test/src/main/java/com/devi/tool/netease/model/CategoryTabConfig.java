package com.devi.tool.netease.model;

import com.devi.tool.netease.CollumComment;
import lombok.Data;

import java.util.Date;

/**
 * 新品后台类目Tab配置实体类
 * Created by hzchendawei on 2018/4/3.
 */
@Data
public class CategoryTabConfig {
    @CollumComment(value = "主键")
    private Long id;

    @CollumComment(value = "名称", nullAble = false)
    private String name;

    @CollumComment(value = "图片icon", length = 1000)
    private String icon;

    @CollumComment(value = "激活图片icon", length = 1000)
    private String activeIcon;

    @CollumComment(value = "链接", length = 1000)
    private String link;

    @CollumComment(value = "开始时间")
    private Date startTime;

    @CollumComment(value = "结束时间")
    private Date endTime;

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
