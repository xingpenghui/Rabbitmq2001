package com.laoxing.rabbitmq.dead;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Rabbitmq2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-21 16:52
 */
@RestController
public class DeadController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("/api/mq/dlxmsg")
    public String sendMsg(String msg){
        System.out.println("发送消息---->"+msg+"---->"+System.currentTimeMillis()/1000);
        rabbitTemplate.convertAndSend(null,"qname-time-order",msg);
        return "OK-"+System.currentTimeMillis();
    }
}
