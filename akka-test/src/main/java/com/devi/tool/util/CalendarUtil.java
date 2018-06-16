package com.devi.tool.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date getDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据字符串类型的日期返回Date
     *
     * @param dateStr    字符型日期
     * @param formartStr 格式
     * @return <br>
     * @author hzchendawei<br>
     * @taskId <br>
     */
    public static Date getDate(String dateStr, String formartStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formartStr);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toDateTimeStr(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        return dateFormat.format(date);
    }

    public static String toDateTimeStr(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 转换时间格式
     *
     * @param format <br>
     * @return
     * @author hzchendawei<br>
     * @taskId <br>
     */
    public static String toDateTimeStr(String dateTime, String format) {
        return toDateTimeStr(getDate(dateTime, DATE_TIME_FORMAT), format);
    }


}
