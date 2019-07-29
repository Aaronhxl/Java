package com.hellobike.rabbitmq.workfair;

import com.hellobike.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * workQueue ：一个生产者多个消费者
 */
public class Send {

    private static final String QUEUE_NAME = "test_work_queue";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        //创建channel
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //每个消费者发送确认消息之前，消息队列不发送下一个消息到消费者，一次只处理一个消息
        //限制发送给同一个消费者不得超过一条
        //channel.basicQos(1);
        //发送消息
        for (int i = 0; i < 50; i++) {
            String msg = "hellobike "+i;
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            System.out.println("send msg: "+msg);
            Thread.sleep(i*5);
        }

        channel.close();
        connection.close();
    }
}
