package com.laoxing.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: Rabbitmq2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-20 16:22
 */
//@Configuration
public class RabbitConfig {
    //创建队列
    @Bean
    public Queue createQue(){
        return new Queue("qname_2001");
    }

    //演示Work模式 一个队列对应多个生产者
    @Bean
    public Queue createQue1(){
        return new Queue("qname_work_2001");
    }

}
