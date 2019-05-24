package com.devi.service;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TestService {

    public String acti() {
        return "hello";
    }

    public static void main(String[] args) {

        BigDecimal c = new BigDecimal("22.9");//19.3

        BigDecimal y = new BigDecimal("4");//6.6

//        BigDecimal x = (new BigDecimal("32.25").subtract((new BigDecimal("1.9488")).add(c)))
//                .divide((new BigDecimal(4.032).add(new BigDecimal("1.8")).add(y)), 5);
//
//        System.out.println("要还：" + x + "年");


        //需要
        BigDecimal need = new BigDecimal("32.25").subtract(new BigDecimal("1.9488")).subtract(c);

        BigDecimal monthC = new BigDecimal("0.336").add(new BigDecimal("0.15"));

        BigDecimal monthPlus = new BigDecimal("0.6");

        BigDecimal needMonth = need.divide((monthC.add(monthPlus)), 5);

        String od = DateTime.now().plusMonths(needMonth.intValue()).toString("yyyy-MM-dd");
        System.out.println("用光现金：" + c + "w ,每月还:" + monthPlus + "w ,需要还的月数：" + needMonth + "   还清时间：" + od);


        c = new BigDecimal("20.24");
        monthPlus = new BigDecimal("0.54");
        need = new BigDecimal("32.25").subtract(new BigDecimal("1.9488")).subtract(c);
        needMonth = need.divide((monthC.add(monthPlus)), 5);
        od = DateTime.now().plusMonths(needMonth.intValue()).toString("yyyy-MM-dd");
        System.out.println("用光现金：" + c + "w ,每月还:" + monthPlus + "w ,需要还的月数：" + needMonth + "   还清时间：" + od);


        c = new BigDecimal("0");
        need = new BigDecimal("32.25").subtract(new BigDecimal("1.9488")).subtract(c);
        monthPlus = new BigDecimal("0.4");
        needMonth = need.divide((monthC.add(monthPlus)), 5);
        od = DateTime.now().plusMonths(needMonth.intValue()).toString("yyyy-MM-dd");
        System.out.println("用光现金：" + c + "w ,每月还:" + monthPlus + "w ,需要还的月数：" + needMonth + "   还清时间：" + od);


        c = new BigDecimal("0");
        need = new BigDecimal("32.25").subtract(new BigDecimal("1.9488")).subtract(c);
        monthPlus = new BigDecimal("0");
        needMonth = need.divide((monthC.add(monthPlus)), 5);
        od = DateTime.now().plusMonths(needMonth.intValue()).toString("yyyy-MM-dd");
        System.out.println("用光现金：" + c + "w ,每月还:" + monthPlus + "w ,需要还的月数：" + needMonth + "   还清时间：" + od);

    }
}
