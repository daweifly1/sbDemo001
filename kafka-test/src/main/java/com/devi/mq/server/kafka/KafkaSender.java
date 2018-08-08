package com.devi.mq.server.kafka;

import com.devi.mq.server.kafka.model.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by hzchendawei on 2018/7/24.
 */
@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send(String content, String topic) {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(content);
        message.setSendTime(System.currentTimeMillis());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send(topic, gson.toJson(message));
    }
}
