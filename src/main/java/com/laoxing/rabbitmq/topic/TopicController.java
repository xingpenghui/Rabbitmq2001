package com.laoxing.rabbitmq.topic;

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
public class TopicController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("api/mq/topicmsg")
    public String sendWorkMsg(String msg,String key){
        rabbitTemplate.convertAndSend("ex_topic_2001",key,msg);
        return "OK";
    }
}
