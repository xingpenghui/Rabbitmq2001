package com.laoxing.rabbitmq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @program: Rabbitmq2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-20 17:05
 */
//@Configuration
public class RabbitFanoutConfig {
    //2个队列
    @Bean
    public Queue createQ1(){
        return new Queue("qname_fanout_2001_01");
    }
    @Bean
    public Queue createQ2(){
        return new Queue("qname_fanout_2001_02");
    }
    //1个交换器
    @Bean
    public FanoutExchange createEx(){
        return new FanoutExchange("ex_fanout_2001",true,true);
    }
    //2绑定
    @Bean
    public Binding createB01(FanoutExchange fx){
        return  BindingBuilder.bind(createQ1()).to(fx);
    }
    @Bean
    public Binding createB02(FanoutExchange fx){
        return  BindingBuilder.bind(createQ2()).to(fx);
    }
}
