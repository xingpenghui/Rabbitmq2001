package com.laoxing.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: Rabbitmq2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-20 16:24
 */
@Component
@RabbitListener(queues = "qname_fanout_2001_02") //设置需要监听的队列
public class FanoutListener02 {
    @RabbitHandler //修饰方法 实现消息的接收
    public void handler(String msg){
        System.out.println("消费者002----"+msg);
    }
}
