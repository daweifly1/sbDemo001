package com.devi;

import com.devi.tool.util.DESCoder;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hzchendawei on 2018/4/12.
 */
public class CommonTest {

    private static final String key = "f3wEtRrV6q0=";

    private static final String sepator = "_______";

    public static void main(String[] args) {

//        System.out.println(getEncyTeamId(9045L));
//
//        String teamId = "9045_______clBZy%2FnsToA%3D";
//        Long realTeamId = 0L;
//        try {
//            realTeamId = Long.valueOf(teamId.split(sepator)[0]);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//        if (!isEffectTeamId(realTeamId, teamId.split(sepator)[1])) {
//            System.out.println("非法teamId参数");
//        } else {
//            System.out.println("ok");
//        }

//        DateTime t=new DateTime("2018-07-01 00:00:00");
//
//        DateTime dateTime = t.withHourOfDay(12).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
//        System.out.println( new Timestamp(dateTime.getMillis()).toString());
//        DateTime birthDate = new DateTime("2018-8-08");
//
//        StringBuilder ageDesc = new StringBuilder();
//        DateTime now = DateTime.now();
//        if (birthDate.isBeforeNow()) {
//            org.joda.time.Period p1 = new org.joda.time.Period(birthDate, now, PeriodType.yearMonthDay());
//            ageDesc.append("今天");
//            //今天出生
//            boolean birth = true;
//            if (p1.getYears() > 0) {
//                ageDesc.append(p1.getYears()).append("岁");
//                birth = false;
//            }
//            if (p1.getMonths() > 0) {
//                ageDesc.append(p1.getMonths()).append("月");
//                birth = false;
//            }
//            if (p1.getDays() > 0) {
//                ageDesc.append(p1.getDays()).append("天");
//                birth = false;
//            }
//            if (birth) {
//                ageDesc.delete(0, ageDesc.length());
//                ageDesc.append("今天是宝宝出生的日子，恭喜你哦~");
//            } else {
//                ageDesc.append("了哦~");
//            }
//        } else {
//            org.joda.time.Period p2 = new org.joda.time.Period(now, birthDate, PeriodType.days());
//            ageDesc.append("距离宝宝出生还有").append(p2.getDays() + 1).append("天哦~");
//        }
//        System.out.println(ageDesc);

//        BabyPlanUrlVO babyPlanUrlVO = new BabyPlanUrlVO();
//        babyPlanUrlVO.setMainUrl("https://m-element.kaola.com/baby/getGrowPrivilege.html");
//        babyPlanUrlVO.setEdit0Url("https://m-element.kaola.com/baby/editBabyInfo.html?edit=edit0");
//        babyPlanUrlVO.setEdit1Url("https://m-element.kaola.com/baby/editBabyInfo.html?edit=edit1");
//        System.out.println(FastJsonUtil.toJSONString(babyPlanUrlVO));

        String str1 = "a";
        String str2 = "b";
        String str3 = str1 + str2;
        System.out.println("===========test5============");
        System.out.println(str3 == "ab"); //false

        str3 = "a" + "b";
        System.out.println("===========test5============");
        System.out.println(str3 == "ab"); //false
//
//        System.out.println(birth.getMonthOfYear() +"===="+ nowDate.getMonthOfYear());
//
//        org.joda.time.Period p3 = new org.joda.time.Period(birth, nowDate, PeriodType.days());
//        System.out.println(p3.getDays());

//        if (birth.getMonthOfYear() != nowDate.getMonthOfYear()) {
//            System.out.println("宝宝非本月出生不能领取");
//        }
//
//        if (p3.getDays() < 0 || p3.getDays() > 30) {
//            System.out.println("出生礼包宝宝出生30天内可以领取");
//        }
//
//        if (p3.getDays() < 100 || p3.getDays() > 130) {
//            System.out.println("百日礼包宝宝出生100-130天内可以领取");
//        }
//
//        List<Long> goodsIdList =new ArrayList<>();
//        goodsIdList.add(null);goodsIdList.add(null);goodsIdList.add(null);goodsIdList.add(null);goodsIdList.add(null);
//        goodsIdList.removeAll(Collections.singleton(null));
//
//        System.out.println(goodsIdList);

    }

    private static boolean isEffectTeamId(Long teamId, String encyTeamId) {
        return (teamId + sepator + encyTeamId).equals(getEncyTeamId(teamId));
    }

    /**
     * 获取加密的团id信息
     *
     * @param teamId 团id
     */
    private static String getEncyTeamId(Long teamId) {
        try {
            byte[] inputData = DESCoder.encrypt(String.valueOf(teamId).getBytes(), key);
            String value = DESCoder.encryptBASE64(inputData).replaceAll("\r|\n", "");
            value = URLEncoder.encode(value, "utf-8");
            return teamId + sepator + value;
        } catch (Exception e) {
            return null;
        }
    }

    private static String removeLastSymbol(String s) {
        String lastSymbol = null;
        Pattern patPunc = Pattern.compile("[, ; . ! ~ : ? ，；。！~ ：？]*$");
        Matcher matcher = patPunc.matcher(s);
        if (matcher.find()) {
            lastSymbol = matcher.group(0);
        }
        if (lastSymbol != null && s.endsWith(lastSymbol)) {
            s = s.substring(0, s.length() - lastSymbol.length());
        }
        return s;
    }

    public static String regMatch(String withinText, String regString) {
        String code = null;
        Pattern pattern = Pattern.compile(regString);
        Matcher matcher = pattern.matcher(withinText);
        if (matcher.find()) {
            matcher.reset();
            while (matcher.find()) {
                code = matcher.group(1);
                System.err.println("aaaa" + code);
                code = matcher.group(0);
                System.err.println("bbbb" + code);
                code = matcher.group(2);
                System.err.println("ccc" + code);
            }
        }
        return code;
    }

    private static boolean checkImgUrlValid(String urlString) {
        URI uri = null;
        try {
            uri = new URI(urlString);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        }

        if (uri.getHost() == null) {
            return false;
        }
        if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https")) {
            return true;
        }
        return false;
    }
}
