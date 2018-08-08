package com.devi.tool.netease.model2;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@ToString
public class BabyImgConfigDto implements Serializable {
    private static final long serialVersionUID = -7236725092615194177L;

    /**
     * 内容类型
     *
     * {@link com.netease.kaola.community.api.enums.manager.discussion.MDiscussionType}
     */
    private Byte type;

    /**
     * 内容id
     */
    private Long id;

    /**
     * 内容详情
     */

    // 标题
    private String title;

    // 描述
    private String desc;

    // 第一张图片
    private String firstImg;

    // 头像
    private String profilePhoto;

    // 昵称
    private String nickName;

    //点赞数
    private int favorNum;

    //用户openid
    private String openid;

    //长文/心得url
    private String url;

    /**
     * #KJDS-90786 文章阅读数
     */
    private Long readNum;

    //用户个人主页url
    private String zoneUrl;

}
