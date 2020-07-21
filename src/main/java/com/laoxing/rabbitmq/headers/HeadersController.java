package com.laoxing.rabbitmq.headers;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: Rabbitmq2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-20 17:09
 */
@RestController
public class HeadersController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("api/mq/headmsgall")
    public String sendWorkMsg1(String msg){
        rabbitTemplate.convertAndSend("ex_headers_2001",null,msg,
                message -> {  //lambda表达式
            MessageProperties properties=message.getMessageProperties();
            properties.getHeaders().put("ver","1.0");
            properties.getHeaders().put("token","abc001");
            return message;
        },new CorrelationData(UUID.randomUUID().toString()));

        return "OK";
    }
    @GetMapping("api/mq/headmsgany")
    public String sendWorkMsg2(String msg){
        rabbitTemplate.convertAndSend("ex_headers_2001",null,msg,
                message -> {  //lambda表达式
                    MessageProperties properties=message.getMessageProperties();
                    properties.getHeaders().put("version","1.0");
                    return message;
                },new CorrelationData(UUID.randomUUID().toString()));

        return "OK";
    }
}
