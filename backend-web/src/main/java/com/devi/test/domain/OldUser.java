package com.devi.test.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class OldUser implements Serializable {
    private String id;

    private String head;

    private String name;

    private String phone;

    private String picture;

    private Integer sex;
}