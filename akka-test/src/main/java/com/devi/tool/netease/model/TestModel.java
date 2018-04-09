package com.devi.tool.netease.model;

import com.devi.tool.netease.CollumComment;
import lombok.Data;

/**
 * Created by hzchendawei on 2018/4/3.
 */
@Data
public class TestModel {
    @CollumComment(value = "主键")
    private Integer id;

    @CollumComment(value = "用户名称")
    private String userName;




}
