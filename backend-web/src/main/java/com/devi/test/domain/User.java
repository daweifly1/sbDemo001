package com.devi.test.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    private Integer id;

    private String head;

    private String name;

    private String phone;

    private String picture;

    private Integer sex;
}