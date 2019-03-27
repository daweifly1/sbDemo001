package com.devi.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TestService {

    public String acti() {
        return "hello";
    }

    public static void main(String[] args) {

        BigDecimal c = new BigDecimal("1.3");//19.3

        BigDecimal y = new BigDecimal("2");//6.6

        BigDecimal x = (new BigDecimal("32.55").subtract((new BigDecimal("1.344")).add(c)))
                .divide((new BigDecimal(3.2256).add(new BigDecimal("1.8")).add(y)), 5);

        System.out.println("要还：" + x + "年");
    }
}
