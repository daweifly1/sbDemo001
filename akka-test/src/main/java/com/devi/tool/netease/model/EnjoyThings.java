package com.devi.tool.netease.model;

import com.devi.tool.netease.CollumComment;
import lombok.Data;

import java.util.Date;

/**
 * 赏物实体类
 * Created by hzchendawei on 2018/4/3.
 */
@Data
public class EnjoyThings {
    @CollumComment(value = "主键")
    private Long id;

    @CollumComment(value = "商品ID", nullAble = false)
    private Long goodsId;

    @CollumComment(value = "商品图片，json", length = 1000)
    private String goodsImg;

    @CollumComment(value = "商品属性", length = 32)
    private String goodsAttribute;

    @CollumComment(value = "一级类目id")
    private Long level1CategoryId;

    @CollumComment(value = "内容标题", length = 32)
    private String contentTitle;

    @CollumComment(value = "赏物推荐语,json", length = 255, nullAble = false)
    private String enjoyRecommend;

    @CollumComment(value = "赏物图片", length = 255)
    private String enjoyRecommendImg;

//    @CollumComment(value = "文章id")
//    private Long articleId;

    @CollumComment(value = "达人推荐", length = 255)
    private String talentRecommend;

    @CollumComment(value = "达人推荐图片", length = 2000)
    private String talentRecommendImg;

//    @CollumComment(value = "达人昵称")
//    private String talentNickname;

    @CollumComment(value = "达人账号", length = 255)
    private String talentId;

//    @CollumComment(value = "达人头像")
//    private String talentImg;

    @CollumComment(value = "用户评价，包括图片评价内容等,json", length = 2000)
    private String comments;

    @CollumComment(value = "状态，0提交 1待审核 2已发布")
    private Integer status;

    @CollumComment(value = "类型 0新增 1导入,2社区初始")
    private Integer type;

    @CollumComment(value = "角标", length = 32)
    private String cornerMark;

    @CollumComment(value = "创建人", length = 64)
    private String dbCreateAuthor;

    @CollumComment(value = "更新人", length = 64)
    private String dbUpdateAuthor;

    @CollumComment(value = "创建时间")
    private Date dbCreateTime;

    @CollumComment(value = "更新时间")
    private Date dbUpdateTime;

}
