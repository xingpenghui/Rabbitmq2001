package com.laoxing.rabbitmq.client;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: Rabbitmq2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-20 11:49
 */
public class SendMsg_Main {
    public static void main(String[] args) throws IOException, TimeoutException {
        //服务器地址：39.105.189.141    5672  账号密码：guest  guest
        //设置连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("39.105.189.141");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        //获取连接对象
        Connection connection=factory.newConnection();
        //创建通道对象
        Channel channel=connection.createChannel();
        //创建队列
        /**
         * 创建队列
         * 参数说明：
         * 1.队列的名称
         * 2.实现进行持久化
         * 3.是否设置为排它消息 ：只允许该队列为声明的人使用，其他不可用使用
         * 4.是否自动删除
         * 5.参数信息*/
        channel.queueDeclare("qname_java_2001",true,false,true,null);
        //发送消息
        /**
         * 发送消息
         * 参数说明：
         * 1.交换器名称
         * 2.路由名称或者队列名称
         * 3.是否自动应答
         * 4.属性信息
         * 5.消息内容*/
        channel.basicPublish("","qname_java_2001",true,null,"饿了吗".getBytes());
        //关闭、销毁
        channel.close();
        connection.close();
    }
}
