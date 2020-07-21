package com.laoxing.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Rabbitmq2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-20 16:22
 */
@RestController
public class MqController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("api/mq/sendmsg")
    public String sendMsg(String msg){
        rabbitTemplate.convertAndSend("qname_2001",msg);
        return "OK";
    }
    @GetMapping("api/mq/workmsg")
    public String sendWorkMsg(String msg){
        rabbitTemplate.convertAndSend("qname_work_2001",msg);
        return "OK";
    }
}
