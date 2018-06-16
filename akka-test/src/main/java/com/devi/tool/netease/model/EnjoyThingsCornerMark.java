package com.devi.tool.netease.model;

import com.devi.tool.netease.CollumComment;
import lombok.Data;

import java.util.Date;

/**
 * 赏物实体类
 * Created by hzchendawei on 2018/4/3.
 */
@Data
public class EnjoyThingsCornerMark {
    @CollumComment(value = "主键")
    private Long id;

    @CollumComment(value = "角标文案", nullAble = false)
    private String cornerMark;

    @CollumComment(value = "商品id列表，英文逗号分隔", length = 2000)
    private String goodsIds;

    @CollumComment(value = "状态，0保存 1发布", nullAble = false)
    private Integer status;

    @CollumComment(value = "开始时间", nullAble = false)
    private Date startTime;

    @CollumComment(value = "结束时间", nullAble = false)
    private Date endTime;

    @CollumComment(value = "创建人", length = 64)
    private String dbCreateAuthor;

    @CollumComment(value = "更新人", length = 64)
    private String dbUpdateAuthor;

    @CollumComment(value = "创建时间")
    private Date dbCreateTime;

    @CollumComment(value = "更新时间")
    private Date dbUpdateTime;

}
