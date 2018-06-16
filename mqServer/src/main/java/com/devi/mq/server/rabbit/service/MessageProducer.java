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
    @Resource(name = "amqpTemplate")
    private AmqpTemplate amqpTemplate;

    @Resource(name = "topicTemplate")
    private AmqpTemplate topicTemplate;

    @Resource(name = "fanoutTemplate")
    private AmqpTemplate fanoutTemplate;

    @Resource(name = "msgTemplate")
    private AmqpTemplate msgTemplate;



    public void sendMessage(Object message) {
        log.info("to send message:{}", message);
        amqpTemplate.convertAndSend("queueTestKey", message);
    }

    public void sendTopicMessage(Object message, String pattern) {
        log.info("sendTopicMessage to send message,pattern:{},message:{}", pattern, message);
        topicTemplate.convertAndSend(pattern, message);
    }

    public void sendFanoutMessage(Object message) {
        log.info("to send message:{}", message);
        fanoutTemplate.convertAndSend("queueTestKey", message);
    }

    public void sendMsg(Object message,String p) {
        log.info("to send message:{}", message);
        msgTemplate.convertAndSend(p, message);
    }
}
