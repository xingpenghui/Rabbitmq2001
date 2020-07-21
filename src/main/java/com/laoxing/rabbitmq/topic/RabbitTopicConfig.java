package com.laoxing.rabbitmq.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @program: Rabbitmq2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-20 17:05
 */
//@Configuration
public class RabbitTopicConfig {
    //2个队列
    @Bean
    public Queue createQ1(){
        return new Queue("qname_topic_2001_01");
    }
    @Bean
    public Queue createQ2(){
        return new Queue("qname_topic_2001_02");
    }
    //1个交换器
    @Bean
    public TopicExchange createEx(){
        return new TopicExchange("ex_topic_2001",true,true);
    }
    //2绑定
    @Bean
    public Binding createB01(TopicExchange fx){
        return  BindingBuilder.bind(createQ1()).to(fx).with("log.#");
    }
    @Bean
    public Binding createB02(TopicExchange fx){
        return  BindingBuilder.bind(createQ2()).to(fx).with("stu.*");
    }
}
