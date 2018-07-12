package com.devi;

import com.devi.tool.util.DESCoder;
import org.joda.time.DateTime;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.sql.Timestamp;
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

        DateTime t=new DateTime("2018-07-01 00:00:00");

        DateTime dateTime = t.withHourOfDay(12).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
        System.out.println( new Timestamp(dateTime.getMillis()).toString());

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
