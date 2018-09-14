package com.devi.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */

@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/hi")
    public Map<String, Object> hi() {
        Map m = new HashMap();
        m.put("hi", "hi");
        return m;
    }


    @GetMapping("/qhi")
    public Map<String, Object> qhi() {
        Map m = new HashMap();
        m.put("hi", "qhi");
        return m;
    }


}
