package com.devi.mq.server.rabbit.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hzchendawei on 2017/12/26.
 */
@Slf4j
@Service
public class MessageProducer {
    @Resource
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object message) {
        log.info("to send message:{}", message);
        amqpTemplate.convertAndSend("queueTestKey", message);
    }
}
