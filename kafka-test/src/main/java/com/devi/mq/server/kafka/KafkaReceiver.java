package com.devi.mq.server.kafka;

import com.google.common.base.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by hzchendawei on 2018/7/24.
 */
@Component
@Slf4j
public class KafkaReceiver {
    @KafkaListener(topics = {"zhisheng"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.fromNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();

            log.info("1----------------- record =" + record);
            log.info("1------------------ message =" + message);
        }

    }


    @KafkaListener(topics = {"zhisheng"})
    public void listen2(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.fromNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();

            log.info("2----------------- record =" + record);
            log.info("2------------------ message =" + message);
        }

    }
}
