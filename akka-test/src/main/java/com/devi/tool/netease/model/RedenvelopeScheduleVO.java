package com.devi.tool.netease.model;

import com.devi.tool.netease.CollumComment;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by hzwangqiqing
 * on 2018/6/19.
 */
@Data
public class RedenvelopeScheduleVO implements Serializable {
    @CollumComment(value = "活动id")
    private Long id;

    @CollumComment(value = "活动名称")
    private String activityName;
    @CollumComment(value = "0-批量类型 1-单个类型")
    private Integer timeType;


    @CollumComment(value = "活动开始时间")
    private Timestamp startTime;

    @CollumComment(value = "活动结束时间")
    private Timestamp endTime;

    @CollumComment(value = "持续天数")
    private Integer days;

    @CollumComment(value = "配置信息")
    private String configMessage;

    @CollumComment(value = "数据创建时间")
    private Timestamp dbCreateTime;

    @CollumComment(value = "记录更新时间")
    private Timestamp dbUpdateTime;

    @CollumComment(value = "记录创建人")
    private String dbCreateAuthor;

    @CollumComment(value = "记录更新人")
    private String dbUpdateAuthor;
}
