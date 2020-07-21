package com.laoxing.rabbitmq.listener;

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
@RabbitListener(queues = "qname_work_2001") //设置需要监听的队列
public class QnameListener01 {
    @RabbitHandler //修饰方法 实现消息的接收
    public void handler(String msg){
        System.out.println("Work模式-消费者01----"+msg);
    }
}
