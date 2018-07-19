package com.devi.tool.util;

import lombok.Data;
import lombok.experimental.Builder;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.PeriodType;

import java.util.Calendar;
import java.util.Date;

/**
 * 宝贝计划文案计算工具类
 * <p>
 * Created by eva on 2016/7/28.
 */
public class BabyContextUtil {

    public static BirthDayDifference generateBirthContext(Integer year, Integer month, Integer date) {

        Calendar today = Calendar.getInstance();

        DateFormatUtils.format(today, DateFormatUtils.ISO_DATE_FORMAT.getPattern());
        today.set(2018, 2, 28);


        if (date == null) {
            date = 1;
        }
        BirthDayDifference birthDayDifference = new BirthDayDifference();
        if (year == null || month == null) {
            return birthDayDifference;
        }
        birthDayDifference.setFilled(true);
        //生日
        Calendar calendar1 = Calendar.getInstance();
        DateFormatUtils.format(calendar1, DateFormatUtils.ISO_DATE_FORMAT.getPattern());
        calendar1.set(year, month - 1, date);


        if (calendar1.getTime().before(today.getTime()) || calendar1.getTime().equals(today.getTime())) {
            birthDayDifference.setBorn(true);
        }

        Integer year2 = today.get(Calendar.YEAR);
        Integer month2 = today.get(Calendar.MONTH) + 1;
        Integer date2 = today.get(Calendar.DATE);

        int differenceYear = year2 - year;
        int differenceMonth = month2 - month;
        int differenceDate = date2 - date;

        if (differenceMonth == 0) {
            birthDayDifference.setBirthMonth(true);
        }

        //年月
        if (differenceDate < 0) {
            differenceMonth = differenceMonth - 1;
            if (month2 == 1) {
                calendar1.set(year2 - 1, 11, date);
            } else {
                calendar1.set(year2, month2 - 2, date);
            }
            long differenceMill = today.getTimeInMillis() - calendar1.getTimeInMillis();
            differenceDate = (int) (differenceMill / DateUtils.MILLIS_PER_DAY) + 1;
        }


        if (differenceMonth < 0) {
            differenceYear = differenceYear - 1;
            differenceMonth = differenceMonth + 12;
            differenceDate++;
        }
        birthDayDifference.setDifferenceYear(differenceYear);
        birthDayDifference.setDifferenceMonth(differenceMonth);
        birthDayDifference.setDifferenceDate(differenceDate);
        return birthDayDifference;
    }

    public static class BirthDayDifference {

        public static final String UN_BIRTH = "孕育中";

        /**
         * 是否有宝贝信息
         */
        private boolean isFilled;

        /**
         * 是否已出生
         */
        private boolean isBorn;

        /**
         * 自然年数差
         */
        private Integer differenceYear;

        /**
         * 自然月数差
         */
        private Integer differenceMonth;

        /**
         * 天数差
         */
        private Integer differenceDate;

        /**
         * 是否生日月
         */
        private boolean isBirthMonth;

        public boolean isFilled() {
            return isFilled;
        }

        public boolean isBorn() {
            return isBorn;
        }

        public void setBorn(boolean born) {
            isBorn = born;
        }

        public void setFilled(boolean filled) {
            isFilled = filled;
        }

        public Integer getDifferenceYear() {
            return differenceYear;
        }

        public void setDifferenceYear(Integer differenceYear) {
            this.differenceYear = differenceYear;
        }

        public Integer getDifferenceMonth() {
            return differenceMonth;
        }

        public void setDifferenceMonth(Integer differenceMonth) {
            this.differenceMonth = differenceMonth;
        }

        public Integer getDifferenceDate() {
            return differenceDate;
        }

        public void setDifferenceDate(Integer differenceDate) {
            this.differenceDate = differenceDate;
        }

        public boolean isBirthMonth() {
            return isBirthMonth;
        }

        public void setBirthMonth(boolean birthMonth) {
            isBirthMonth = birthMonth;
        }

        public String getBirthContext() {
            if (!isFilled) {
                return "生日";
            }
            if (!isBorn) {
                return "孕育中";
            }
            if (differenceYear == 0 && differenceMonth == 0 && differenceDate == 0) {
                return "破蛋快乐";
            }
            if (isBirthMonth && differenceYear >= 0) {
                if (differenceMonth == 11) {
                    return (differenceYear + 1) + "周岁快乐";
                }
                return differenceYear + "周岁快乐";
            }
            int maxNum = 2;
            int count = 0;
            StringBuilder builder = new StringBuilder();
            if (differenceYear != null && differenceYear != 0) {
                builder.append(differenceYear + "岁");
                count++;
            }
            if (differenceMonth != null && differenceMonth != 0) {
                builder.append(differenceMonth + "个月");
                count++;
            } else {
                if (count != 0) {
                    count++;
                }
            }
            if (differenceDate != 0) {
                builder.append(differenceDate + "天");
            }
//            if (count < maxNum && differenceDate != null && differenceDate != 0) {

//                int weekNum = differenceDate / 7;
//                if (weekNum != 0) {
//                    builder.append(weekNum + "周");
//                    count++;
//                } else {
//                    if (count != 0) {
//                        count++;
//                    }
//                }
//                if (count < maxNum) {
//                    int dayNum = differenceDate % 7;
//                    if (dayNum != 0) {
//                        builder.append(dayNum + "天");
//                        count++;
//                    }
//                }
//            }

            if (builder.length() == 0) {
                builder.append(UN_BIRTH);
            }
            return builder.toString();
        }

        public Integer getMonthAge() {


            int monthAge = 0;
            if (this.differenceMonth != null) {
                monthAge += this.differenceMonth;
            }
            if (this.differenceYear != null) {
                monthAge += this.differenceYear * 12;
            }
            /**
             * 如果未出生，则monthAgo至少为-1
             */
            if ((!this.isBorn) && monthAge == 0) {
                monthAge = -1;
            }
            /**
             * 如果未填写，则monthAgo至少为-11
             */
            if (!this.isFilled && monthAge > -10) {
                monthAge = -11;
            }

            return monthAge;
        }
    }

    public static void main(String[] args) {
//        String s = BabyContextUtil.generateBirthContext(2018, 1, 31).getBirthContext();
//        System.out.println("2018, 6, 1======" + s);
//
//        String s2 = BabyContextUtil.generateBirthContext(2018, 1, 30).getBirthContext();
//        System.out.println("2018, 5, 31======" + s2);

//        Date birth=new DateTime("2018-01-31").toDate();
//
//        Date today=new DateTime("2018-02-28").toDate();
//
//        DayCompare s=dayComparePrecise(birth,today);
//        System.out.println(s);
//
//        LocalDate f= LocalDate.of(2018,1,31);
//        LocalDate t=LocalDate.of(2018,3,1);
//        Period p=Period.between(f,t);
//
//        System.out.println(p.getYears()+"--"+p.getMonths()+"--"+p.getDays());


        DateTime end = new DateTime("2018-5-31");
        DateTime begin = new DateTime("2018-7-2");
        org.joda.time.Period p2 = new org.joda.time.Period(begin, end);
        System.out.println(p2.getYears() + "--" + p2.getMonths() + "--" + p2.getDays());

        String effectiveDate = DateTime.now().toString("yyyyMM");
        System.out.println(effectiveDate);

        DateTime birthDate = new DateTime("2018-6-17");
        org.joda.time.Period p3 = new org.joda.time.Period(birthDate, DateTime.now(), PeriodType.months());
        System.out.println("2018-6-17 出生的月龄:" + p3.getMonths());

        birthDate = new DateTime("2018-6-16");
        p3 = new org.joda.time.Period(birthDate, DateTime.now(), PeriodType.months());
        System.out.println("2018-6-16 出生的月龄:" + p3.getMonths());

        birthDate = new DateTime("2018-6-18");
         p3 = new org.joda.time.Period(birthDate, DateTime.now(), PeriodType.months());
        System.out.println("2018-6-18 出生的月龄:" + p3.getMonths());
    }


    public static DayCompare dayComparePrecise(Date fromDate, Date toDate) {
        Calendar from = Calendar.getInstance();
        from.setTime(fromDate);
        Calendar to = Calendar.getInstance();
        to.setTime(toDate);

        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int fromDay = from.get(Calendar.DAY_OF_MONTH);

        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int toDay = to.get(Calendar.DAY_OF_MONTH);

        //直接差
        int year = toYear - fromYear;
        int month = toMonth - fromMonth;
        int day = toDay - fromDay;

        //年月
        if (day < 0) {
            month = month - 1;


            if (toMonth == 1) {
                to.set(toYear - 1, 11, toDay);
            } else {
                to.set(toYear, toMonth - 2, toDay);
            }
            long differenceMill = to.getTimeInMillis() - from.getTimeInMillis();
            day = (int) (differenceMill / DateUtils.MILLIS_PER_DAY) + 1;
        }

        return DayCompare.builder().day(day).month(month).year(year).build();
    }

    @Data
    @Builder
    public static class DayCompare {
        private int year;
        private int month;
        private int day;
    }

}
