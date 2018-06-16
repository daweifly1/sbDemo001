package com.devi.mq.server.rabbit.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by hzchendawei on 2017/12/26.
 */
@Slf4j
public class MessageConsumer implements MessageListener {


    @Override
    public void onMessage(Message message) {
        log.info("SSSS  receive message:{}", message);
    }

}
