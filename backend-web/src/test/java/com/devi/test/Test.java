package com.devi.test;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzchendawei on 2017/9/13.
 */
public class Test {

    public static final int DISPATCH_SUCCESS = 200;// 优惠券派发验证-派发成功
    public static final int DISPATCH_SCHEME_NULL = -1;// 优惠券派发验证-方案为null
    public static final int DISPATCH_SCHEME_STATUS_ERROR = -2;// 优惠券派发验证-方案状态错误
    public static final int DISPATCH_SCHEME_DISPATCH_TIME_ERROR = -3;// 优惠券派发验证-不在派发时间内
    public static final int DISPATCH_SCHEME_ISSUE_TYPE_ERROR = -4;// 优惠券派发验证-优惠券类型错误
    public static final int DISPATCH_SCHEME_THRESHOLD_ERROR = -5;// 优惠券派发验证-阀值错误
    public static final int DISPATCH_COUPON_AMOUNT_ERROR = -6;// 优惠券派发验证-金额错误
    public static final int DISPATCH_TOTAL_LIMIT_ERROR = -7;// 优惠券派发验证-总派发数量限制错误
    public static final int DISPATCH_OVER_TOTAL_LIMIT = -8;// 优惠券派发验证-超过总派发数量限制
    public static final int DISPATCH_DAILY_LIMIT_ERROR = -9;// 优惠券派发验证-每天派发数量限制错误
    public static final int DISPATCH_OVER_DAILY_LIMIT = -10;// 优惠券派发验证-超过每天派发数量限制
    public static final int DISPATCH_ACCOUNT_LIMIT_ERROR = -11;// 优惠券派发验证-每个账户派发数量限制错误
    public static final int DISPATCH_OVER_ACCOUNT_LIMIT = -12;// 优惠券派发验证-超过每个账户派发数量限制
    public static final int DISPATCH_EXPIRE_TIME_TYPE_ERROR = -13;// 优惠券派发验证-过期时间类型错误
    public static final int DISPATCH_EXPIRE_DAYS_ERROR = -14;// 优惠券派发验证-过期时间天数错误
    public static final int DISPATCH_COUPON_TIME_ERROR = -15;// 优惠券派发验证-优惠券使用时间错误
    public static final int DISPATCH_ACCOUNT_ERROR = -16;// 优惠券派发验证-用户名错误
    public static final int DISPATCH_DISTRIBUTE_TYPE_ERROR = -17;// 优惠券派发验证-派发类型错误
    public static final int DISPATCH_DB_ERROR = -18;// 优惠券派发验证-操作数据库错误
    public static final int DISPATCH_REDEEMCODE_NULL = -19;// 优惠券派发验证-兑换码错误
    public static final int DISPATCH_REDEEMCODE_STATUS_ERROR = -20;// 优惠券派发验证-兑换码状态错误
    public static final int DISPATCH_REDEEMCODE_TOTAL_LIMIT_ERROR = -21;// 优惠券派发验证-兑换码总使用次数错误
    public static final int DISPATCH_REDEEMCODE_OVER_USETIME_LIMIT = -22;// 优惠券派发验证-超过兑换码使用次数限制
    public static final int DISPATCH_SCHEME_DISPATCH_BEFORE_TIME_ERROR = -23;// 优惠券派发验证-派发还没开始
    public static final int DISPATCH_SCHEME_DISPATCH_AFTER_TIME_ERROR = -24;// 优惠券派发验证-派发时间已过
    public static final int DISPATCH_ACCOUNT_NOT_NEW_ERROR = -25;// 优惠券派发验证-非新用户
    public static final int DISPATCH_COUPON_CHEAT = -26;// 优惠券派发验证-作弊
    public static final int DISPATCH_SCHEME_DISPATCH_TIME_EMPTY = -31;// 优惠券派发验证-方案起始或结束时间为空
    public static final int DISPATCH_NOT_SPECIFY_USER = -35;  // 仅限指定用户领取
    public static final int DISPATCH_NOT_BLACK_CARD_MEMBER = -38;  // 开通黑卡会员即可领取哦~
    public static final int DISPATCH_NOT_BLACK_CARD_PREMIUM_MEMBER = -39;  // 开通黑卡正式会员即可领取哦~
    public static final int DISPATCH_NOT_BLACK_CARD_TRIAL_MEMBER = -40;  // 开通黑卡试用会员即可领取哦~

    /**
     * 非老用户
     **/
    public static final int DISPATCH_ACCOUNT_NOT_OLD_ERROR = -29;

    /**
     * 优惠券禁止直接兑换
     */
    public static final int DISPATCH_DISABLED_EXCHANGE_DIRECTLY = -30;

    public static final String DISPATCH_REDEEMCODE_INNER_ERROR = "服务器出错了";

    public static final Map<Integer, String> DISPATCH_DESC_MAP_SHOW = new HashMap<Integer, String>();

    static {
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_SCHEME_NULL, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_SCHEME_STATUS_ERROR, "优惠券已停止派发");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_SCHEME_DISPATCH_TIME_ERROR, "未到派发时间");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_SCHEME_ISSUE_TYPE_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_SCHEME_THRESHOLD_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_COUPON_AMOUNT_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_TOTAL_LIMIT_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_OVER_TOTAL_LIMIT, "优惠券已领完");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_DAILY_LIMIT_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_OVER_DAILY_LIMIT, "今日优惠券已领完");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_ACCOUNT_LIMIT_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_OVER_ACCOUNT_LIMIT, "您已领过该优惠券");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_EXPIRE_TIME_TYPE_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_EXPIRE_DAYS_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_COUPON_TIME_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_ACCOUNT_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_DISTRIBUTE_TYPE_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_DB_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_REDEEMCODE_NULL, "兑换码错误");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_REDEEMCODE_STATUS_ERROR, "兑换码已使用");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_REDEEMCODE_TOTAL_LIMIT_ERROR, DISPATCH_REDEEMCODE_INNER_ERROR);
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_REDEEMCODE_OVER_USETIME_LIMIT, "兑换码已失效");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_SCHEME_DISPATCH_BEFORE_TIME_ERROR, "未到领取时间");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_SCHEME_DISPATCH_AFTER_TIME_ERROR, "优惠券领取已结束");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_ACCOUNT_NOT_NEW_ERROR, "该优惠券仅限新人领取");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_ACCOUNT_NOT_OLD_ERROR, "新用户无法领取该券");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_COUPON_CHEAT, "优惠券领取失败");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_DISABLED_EXCHANGE_DIRECTLY, "该优惠券不支持兑换");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_SCHEME_DISPATCH_TIME_EMPTY, "未到领取时间");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_NOT_SPECIFY_USER, "该优惠券仅限指定用户领取");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_NOT_BLACK_CARD_MEMBER, "开通黑卡会员即可领取哦~");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_NOT_BLACK_CARD_PREMIUM_MEMBER, "开通黑卡正式会员即可领取哦~");
        DISPATCH_DESC_MAP_SHOW.put(DISPATCH_NOT_BLACK_CARD_TRIAL_MEMBER, "开通黑卡试用会员即可领取哦~");
    }


    public static void main(String[] args) {
//        test1()

        String ss = "2";
        System.out.println(ss.equals(2 + ""));
        Map<Long, Boolean> m = new HashMap<>();
        Long id=999L;
        m.put(id, true);
        System.out.println(Boolean.TRUE == m.get(id));




    }


    private static void test1() {
        String s = "    public static final int DISPATCH_SUCCESS = 200;// 优惠券派发验证-派发成功\n" +
                "    public static final int DISPATCH_SCHEME_NULL = -1;// 优惠券派发验证-方案为null\n" +
                "    public static final int DISPATCH_SCHEME_STATUS_ERROR = -2;// 优惠券派发验证-方案状态错误\n" +
                "    public static final int DISPATCH_SCHEME_DISPATCH_TIME_ERROR = -3;// 优惠券派发验证-不在派发时间内\n" +
                "    public static final int DISPATCH_SCHEME_ISSUE_TYPE_ERROR = -4;// 优惠券派发验证-优惠券类型错误\n" +
                "    public static final int DISPATCH_SCHEME_THRESHOLD_ERROR = -5;// 优惠券派发验证-阀值错误\n" +
                "    public static final int DISPATCH_COUPON_AMOUNT_ERROR = -6;// 优惠券派发验证-金额错误\n" +
                "    public static final int DISPATCH_TOTAL_LIMIT_ERROR = -7;// 优惠券派发验证-总派发数量限制错误\n" +
                "    public static final int DISPATCH_OVER_TOTAL_LIMIT = -8;// 优惠券派发验证-超过总派发数量限制\n" +
                "    public static final int DISPATCH_DAILY_LIMIT_ERROR = -9;// 优惠券派发验证-每天派发数量限制错误\n" +
                "    public static final int DISPATCH_OVER_DAILY_LIMIT = -10;// 优惠券派发验证-超过每天派发数量限制\n" +
                "    public static final int DISPATCH_ACCOUNT_LIMIT_ERROR = -11;// 优惠券派发验证-每个账户派发数量限制错误\n" +
                "    public static final int DISPATCH_OVER_ACCOUNT_LIMIT = -12;// 优惠券派发验证-超过每个账户派发数量限制\n" +
                "    public static final int DISPATCH_EXPIRE_TIME_TYPE_ERROR = -13;// 优惠券派发验证-过期时间类型错误\n" +
                "    public static final int DISPATCH_EXPIRE_DAYS_ERROR = -14;// 优惠券派发验证-过期时间天数错误\n" +
                "    public static final int DISPATCH_COUPON_TIME_ERROR = -15;// 优惠券派发验证-优惠券使用时间错误\n" +
                "    public static final int DISPATCH_ACCOUNT_ERROR = -16;// 优惠券派发验证-用户名错误\n" +
                "    public static final int DISPATCH_DISTRIBUTE_TYPE_ERROR = -17;// 优惠券派发验证-派发类型错误\n" +
                "    public static final int DISPATCH_DB_ERROR = -18;// 优惠券派发验证-操作数据库错误\n" +
                "    public static final int DISPATCH_REDEEMCODE_NULL = -19;// 优惠券派发验证-兑换码错误\n" +
                "    public static final int DISPATCH_REDEEMCODE_STATUS_ERROR = -20;// 优惠券派发验证-兑换码状态错误\n" +
                "    public static final int DISPATCH_REDEEMCODE_TOTAL_LIMIT_ERROR = -21;// 优惠券派发验证-兑换码总使用次数错误\n" +
                "    public static final int DISPATCH_REDEEMCODE_OVER_USETIME_LIMIT = -22;// 优惠券派发验证-超过兑换码使用次数限制\n" +
                "    public static final int DISPATCH_SCHEME_DISPATCH_BEFORE_TIME_ERROR = -23;// 优惠券派发验证-派发还没开始\n" +
                "    public static final int DISPATCH_SCHEME_DISPATCH_AFTER_TIME_ERROR = -24;// 优惠券派发验证-派发时间已过\n" +
                "    public static final int DISPATCH_ACCOUNT_NOT_NEW_ERROR = -25;// 优惠券派发验证-非新用户\n" +
                "    public static final int DISPATCH_COUPON_CHEAT = -26;// 优惠券派发验证-作弊\n" +
                "    public static final int DISPATCH_SCHEME_DISPATCH_TIME_EMPTY = -31;// 优惠券派发验证-方案起始或结束时间为空\n" +
                "    public static final int DISPATCH_NOT_SPECIFY_USER = -35;  // 仅限指定用户领取\n" +
                "    public static final int DISPATCH_NOT_BLACK_CARD_MEMBER = -38;  // 开通黑卡会员即可领取哦~\n" +
                "    public static final int DISPATCH_NOT_BLACK_CARD_PREMIUM_MEMBER = -39;  // 开通黑卡正式会员即可领取哦~\n" +
                "    public static final int DISPATCH_NOT_BLACK_CARD_TRIAL_MEMBER = -40;  // 开通黑卡试用会员即可领取哦~";

        Map<String, String> tmap = new HashMap<>();
        Map<String, String> m = new HashMap<>();

        String[] ss = s.split("\n");
        for (String a : ss) {
            if (StringUtils.isEmpty(a)) {
                continue;
            }
            String title = a.substring(a.indexOf("int") + 3, a.lastIndexOf("=")).trim();
            String k = a.substring(a.indexOf("=") + 1, a.lastIndexOf(";")).trim();
            String v = a.substring(a.lastIndexOf("//") + 2).trim();
            if (StringUtils.isEmpty(k) || StringUtils.isEmpty(v) || StringUtils.isEmpty(title)) {
                continue;
            }
            m.put(k, v);
            tmap.put(k, title);
        }


        for (Map.Entry entry : DISPATCH_DESC_MAP_SHOW.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();

            String title = tmap.get(key);
            String reason = m.get(key);

            System.out.println("" + title + "(\"" + key + "\",\"" + value + "\",\"" + reason + "\"),");


        }
    }
}
