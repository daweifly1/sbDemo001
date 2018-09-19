package com.devi.test.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder n = new BCryptPasswordEncoder(8);

        System.out.println(n.encode("admin"));
    }
}
