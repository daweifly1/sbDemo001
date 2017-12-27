package com.devi.mq.server.rabbit;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by hzchendawei on 2017/12/26.
 */
@Configuration
@ImportResource(locations={"classpath:rabbitMq.xml"})
public class Config {

}
