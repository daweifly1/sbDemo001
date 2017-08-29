package com.devi.test.controller;

import com.devi.test.result.ResultDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public ResultDO<String> get(@RequestParam("content") String content) {
        ResultDO<String> resultDO = new ResultDO<>();
        resultDO.setSuccess(true);
        resultDO.setData(content);
        return resultDO;
    }
}
