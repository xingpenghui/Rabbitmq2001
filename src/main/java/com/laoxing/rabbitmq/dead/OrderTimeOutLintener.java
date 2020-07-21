package com.laoxing.rabbitmq.dead;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: Rabbitmq2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-21 16:54
 */
@Component
@RabbitListener(queues = "qname-timeout-order")
public class OrderTimeOutLintener {
    @RabbitHandler
    public void handler(String msg){
        System.out.println("消息--->"+msg+"------>"+System.currentTimeMillis()/1000);
    }
}
