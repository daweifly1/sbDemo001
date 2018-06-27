package com.devi.tool.netease.model2;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
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

    public static void main(String[] args) {
        RedenvelopeScheduleVO model = new RedenvelopeScheduleVO();


        model.setId(8L);
        model.setActivityName("111");
        model.setTimeType(1);
        Timestamp t4 = new Timestamp(1530028800000L);
        model.setStartTime(t4);
        Timestamp t5 = new Timestamp(1531497584000L);
        model.setEndTime(t5);
        model.setNewAccountLimit(new BigDecimal(11));
        model.setOldAccountLimit(new BigDecimal(11));
        model.setDays(3);
        model.setTeamLeaderEveryDay(11);
        model.setMemberEveryDay(11);
        model.setTeamLeaderActivityTime(11);
        model.setMemberActivityTime(11);
        model.setInterest("1111");
        List list14 = new ArrayList<RedenvelopeVO>();
        RedenvelopeVO redenvelopeVO1 = new RedenvelopeVO();
        redenvelopeVO1.setCouponSchemaId(17041L);
        redenvelopeVO1.setRedEnvolpeFrontId("4eeb83ccb8d84967ac1b04de4cd08b94");
        redenvelopeVO1.setCouponAmount(new BigDecimal(10000.00));
        redenvelopeVO1.setCouponName("组团瓜分红包test1");
        Timestamp tredenvelopeVO15 = new Timestamp(1529942400000L);
        redenvelopeVO1.setCouponOpenTime(tredenvelopeVO15);
        Timestamp tredenvelopeVO16 = new Timestamp(1545753540000L);
        redenvelopeVO1.setCouponCloseTime(tredenvelopeVO16);
        redenvelopeVO1.setCouponActivtyTime(null);
        redenvelopeVO1.setCouponExpireTime(null);
        redenvelopeVO1.setExpireDays(1);
        redenvelopeVO1.setReceiveStatus(3);
        redenvelopeVO1.setReceiveTime(null);
        redenvelopeVO1.setIdempotent("oxygh");
        redenvelopeVO1.setDispatcherOver(false);
        list14.add(redenvelopeVO1);
        RedenvelopeVO redenvelopeVO2 = new RedenvelopeVO();
        redenvelopeVO2.setCouponSchemaId(17041L);
        redenvelopeVO2.setRedEnvolpeFrontId("4eeb83ccb8d84967ac1b04de4cd08b94");
        redenvelopeVO2.setCouponAmount(new BigDecimal(10000.00));
        redenvelopeVO2.setCouponName("组团瓜分红包test1");
        Timestamp tredenvelopeVO25 = new Timestamp(1529942400000L);
        redenvelopeVO2.setCouponOpenTime(tredenvelopeVO25);
        Timestamp tredenvelopeVO26 = new Timestamp(1545753540000L);
        redenvelopeVO2.setCouponCloseTime(tredenvelopeVO26);
        redenvelopeVO2.setCouponActivtyTime(null);
        redenvelopeVO2.setCouponExpireTime(null);
        redenvelopeVO2.setExpireDays(1);
        redenvelopeVO2.setReceiveStatus(3);
        redenvelopeVO2.setReceiveTime(null);
        redenvelopeVO2.setIdempotent("yn9mU");
        redenvelopeVO2.setDispatcherOver(false);
        list14.add(redenvelopeVO2);
        RedenvelopeVO redenvelopeVO3 = new RedenvelopeVO();
        redenvelopeVO3.setCouponSchemaId(17041L);
        redenvelopeVO3.setRedEnvolpeFrontId("4eeb83ccb8d84967ac1b04de4cd08b94");
        redenvelopeVO3.setCouponAmount(new BigDecimal(10000.00));
        redenvelopeVO3.setCouponName("组团瓜分红包test1");
        Timestamp tredenvelopeVO35 = new Timestamp(1529942400000L);
        redenvelopeVO3.setCouponOpenTime(tredenvelopeVO35);
        Timestamp tredenvelopeVO36 = new Timestamp(1545753540000L);
        redenvelopeVO3.setCouponCloseTime(tredenvelopeVO36);
        redenvelopeVO3.setCouponActivtyTime(null);
        redenvelopeVO3.setCouponExpireTime(null);
        redenvelopeVO3.setExpireDays(1);
        redenvelopeVO3.setReceiveStatus(2);
        redenvelopeVO3.setReceiveTime(null);
        redenvelopeVO3.setIdempotent("sbaMv");
        redenvelopeVO3.setDispatcherOver(false);
        list14.add(redenvelopeVO3);
        RedenvelopeVO redenvelopeVO4 = new RedenvelopeVO();
        redenvelopeVO4.setCouponSchemaId(17041L);
        redenvelopeVO4.setRedEnvolpeFrontId("4eeb83ccb8d84967ac1b04de4cd08b94");
        redenvelopeVO4.setCouponAmount(new BigDecimal(10000.00));
        redenvelopeVO4.setCouponName("组团瓜分红包test1");
        Timestamp tredenvelopeVO45 = new Timestamp(1529942400000L);
        redenvelopeVO4.setCouponOpenTime(tredenvelopeVO45);
        Timestamp tredenvelopeVO46 = new Timestamp(1545753540000L);
        redenvelopeVO4.setCouponCloseTime(tredenvelopeVO46);
        redenvelopeVO4.setCouponActivtyTime(null);
        redenvelopeVO4.setCouponExpireTime(null);
        redenvelopeVO4.setExpireDays(1);
        redenvelopeVO4.setReceiveStatus(2);
        redenvelopeVO4.setReceiveTime(null);
        redenvelopeVO4.setIdempotent("t18Xl");
        redenvelopeVO4.setDispatcherOver(false);
        list14.add(redenvelopeVO4);
        RedenvelopeVO redenvelopeVO5 = new RedenvelopeVO();
        redenvelopeVO5.setCouponSchemaId(17041L);
        redenvelopeVO5.setRedEnvolpeFrontId("4eeb83ccb8d84967ac1b04de4cd08b94");
        redenvelopeVO5.setCouponAmount(new BigDecimal(10000.00));
        redenvelopeVO5.setCouponName("组团瓜分红包test1");
        Timestamp tredenvelopeVO55 = new Timestamp(1529942400000L);
        redenvelopeVO5.setCouponOpenTime(tredenvelopeVO55);
        Timestamp tredenvelopeVO56 = new Timestamp(1545753540000L);
        redenvelopeVO5.setCouponCloseTime(tredenvelopeVO56);
        redenvelopeVO5.setCouponActivtyTime(null);
        redenvelopeVO5.setCouponExpireTime(null);
        redenvelopeVO5.setExpireDays(1);
        redenvelopeVO5.setReceiveStatus(2);
        redenvelopeVO5.setReceiveTime(null);
        redenvelopeVO5.setIdempotent("dibrw");
        redenvelopeVO5.setDispatcherOver(false);
        list14.add(redenvelopeVO5);
        model.setRedenvelopeVOList(list14);
        RedenvelopeVO redenvelopeVO15 = new RedenvelopeVO();
        redenvelopeVO15.setCouponSchemaId(17041L);
        redenvelopeVO15.setRedEnvolpeFrontId("4eeb83ccb8d84967ac1b04de4cd08b94");
        redenvelopeVO15.setCouponAmount(new BigDecimal(10000.00));
        redenvelopeVO15.setCouponName("组团瓜分红包test1");
        Timestamp tredenvelopeVO155 = new Timestamp(1529942400000L);
        redenvelopeVO15.setCouponOpenTime(tredenvelopeVO155);
        Timestamp tredenvelopeVO156 = new Timestamp(1545753540000L);
        redenvelopeVO15.setCouponCloseTime(tredenvelopeVO156);
        redenvelopeVO15.setCouponActivtyTime(null);
        redenvelopeVO15.setCouponExpireTime(null);
        redenvelopeVO15.setExpireDays(1);
        redenvelopeVO15.setReceiveStatus(0);
        redenvelopeVO15.setReceiveTime(null);
        redenvelopeVO15.setIdempotent("wbLCx");
        redenvelopeVO15.setDispatcherOver(false);
        model.setBaseRedenvelopeVO(redenvelopeVO15);
        RedenvelopeVO redenvelopeVO16 = new RedenvelopeVO();
        redenvelopeVO16.setCouponSchemaId(17042L);
        redenvelopeVO16.setRedEnvolpeFrontId("dbb5b95d27b045979a1142a6b88ab73d");
        redenvelopeVO16.setCouponAmount(new BigDecimal(10000.00));
        redenvelopeVO16.setCouponName("组团瓜分红包test3");
        Timestamp tredenvelopeVO165 = new Timestamp(1529942400000L);
        redenvelopeVO16.setCouponOpenTime(tredenvelopeVO165);
        Timestamp tredenvelopeVO166 = new Timestamp(1545753540000L);
        redenvelopeVO16.setCouponCloseTime(tredenvelopeVO166);
        Timestamp tredenvelopeVO167 = new Timestamp(1529942400000L);
        redenvelopeVO16.setCouponActivtyTime(tredenvelopeVO167);
        Timestamp tredenvelopeVO168 = new Timestamp(1545753540000L);
        redenvelopeVO16.setCouponExpireTime(tredenvelopeVO168);
        redenvelopeVO16.setExpireDays(1);
        redenvelopeVO16.setReceiveStatus(1);
        redenvelopeVO16.setReceiveTime(null);
        redenvelopeVO16.setIdempotent("wQhfc");
        redenvelopeVO16.setDispatcherOver(false);


        model.setNewRedenvelopeVO(redenvelopeVO16);
        model.setLegoPageLink("111");
        model.setPageJumpLink("http://mp-kl.kaola.com/redEnvelope.html");
        model.setConfigMessage("gji02");
        Timestamp t20 = new Timestamp(1530023405398L);
        model.setDbCreateTime(t20);
        Timestamp t21 = new Timestamp(1530023405398L);
        model.setDbUpdateTime(t21);
        model.setDbCreateAuthor("SystemRequest");
        model.setDbUpdateAuthor("SystemRequest");
        Timestamp t24 = new Timestamp(1530065701079L);
        model.setCurTime(t24);
        System.out.println(model);
    }
}
