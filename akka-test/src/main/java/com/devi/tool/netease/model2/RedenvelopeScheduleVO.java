package com.devi.tool.netease.model2;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by hzwangqiqing
 * on 2018/6/19.
 */
@Data
public class RedenvelopeScheduleVO implements Serializable {
    private static final long serialVersionUID = 9180962772178965795L;

    //活动id
    private Long id;

    //活动名称
    private String activityName;

    //0-批量类型 1-单个类型
    private Integer timeType;

    //活动开始时间
    private Timestamp startTime;

    //活动结束时间
    private Timestamp endTime;

    //新账户红包活动领取上限
    private BigDecimal newAccountLimit;

    //老客红包上限
    private BigDecimal oldAccountLimit;

    //持续天数
    private Integer days;

    //作为团长的每天上限,活动期间每人发起组队的次数
    private Integer teamLeaderEveryDay;

    //团员每天上限，活动期间每人参与组队的次数
    private Integer memberEveryDay;

    //活动期间的团长上限，每天每人发起组队的次数
    private Integer teamLeaderActivityTime;

    //成员每天数量，每天每人参与组队的次数
    private Integer memberActivityTime;

    //利益点
    private String interest;

    //获取期间领取的红包id
    private List<RedenvelopeVO> redenvelopeVOList;

    //兜底红包信息
    private RedenvelopeVO baseRedenvelopeVO;

    //新客红包id
    private RedenvelopeVO newRedenvelopeVO;

    //乐高页面链接
    private String legoPageLink;

    //页面跳转链接
    private String pageJumpLink;

    //配置信息
    private String configMessage;

    //数据创建时间
    private Timestamp dbCreateTime;

    //记录更新时间
    private Timestamp dbUpdateTime;

    //记录创建人
    private String dbCreateAuthor;

    //记录更新人
    private String dbUpdateAuthor;

    //当前时间
    private Timestamp curTime;
}
