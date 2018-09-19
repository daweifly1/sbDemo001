package com.devi.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping(value = "/hi")
    public Map<String, Object> hi() {
        Map m = new HashMap();
        m.put("hi", "hi");
        return m;
    }


    @GetMapping(value = "/qhi")
    public Map<String, Object> qhi() {
        Map m = new HashMap();
        m.put("hi", "qhi");
        return m;
    }
}
