package com.devi.mq.server.rabbit.commom;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by hzchendawei on 2017/12/26.
 */
@Slf4j
public class Producer extends EndPoint {

    public Producer(String endPointName) throws IOException {
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException {
        log.info("sendMessage:{}", object);
        channel.basicPublish("", endPointName, null, SerializationUtils.serialize(object));
    }
}

