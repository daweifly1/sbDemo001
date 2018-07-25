package com.devi.mq.server.kafka.model;

import lombok.Data;

/**
 * Created by hzchendawei on 2018/7/24.
 */
@Data
public class Message {
    private Long id;

    private String msg;

    private long sendTime;

}
