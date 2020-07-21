package com.laoxing.rabbitmq.direct;

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
public class RabbitDirectConfig {
    //2个队列
    @Bean
    public Queue createQ1(){
        return new Queue("qname_direct_2001_01");
    }
    @Bean
    public Queue createQ2(){
        return new Queue("qname_direct_2001_02");
    }
    //1个交换器
    @Bean
    public DirectExchange createEx(){
        return new DirectExchange("ex_direct_2001",true,true);
    }
    //2绑定
    @Bean
    public Binding createB01(DirectExchange fx){
        return  BindingBuilder.bind(createQ1()).to(fx).with("log");
    }
    @Bean
    public Binding createB02(DirectExchange fx){
        return  BindingBuilder.bind(createQ2()).to(fx).with("log");
    }
}
