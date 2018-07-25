package com.devi.mq.server.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package KafkaController
 * @Description: KafkaController
 * @Copyright: Copyright (c) 2016
 * @date 2017/5/19 10:32
 * version V1.0.0
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaSender producer;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public Map<String, Object> get(@RequestParam("content") String content) {
        Map<String, Object> resultDO = new HashMap<>();
        try {
            producer.send();
            resultDO.put("success", true);
        } catch (Exception e) {
            resultDO.put("success", false);
            resultDO.put("message", e.getMessage());
        }
        return resultDO;
    }
}
