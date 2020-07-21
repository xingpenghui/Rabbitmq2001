package com.laoxing.rabbitmq.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Rabbitmq2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-20 17:09
 */
@RestController
public class FanoutController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("api/mq/fanoutmsg")
    public String sendWorkMsg(String msg){
        rabbitTemplate.convertAndSend("ex_fanout_2001",null,msg);
        return "OK";
    }
}
