package com.devi.tool.netease.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class BabyAgeImgItem implements Serializable {
    //年龄段主键
    private Long id;

    //年龄段信息
    private String agedesc;

    //背景图片信息
    private String img;
}
