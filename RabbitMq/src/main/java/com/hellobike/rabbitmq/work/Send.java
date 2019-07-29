package com.hellobike.rabbitmq.work;

import com.hellobike.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * workQueue ：一个生产者多个消费者
 * 非公平队列：round-robin -- 官方叫法
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
        //发送消息
        for (int i = 0; i < 50; i++) {
            String msg = "hellobike "+i;
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            System.out.println("send msg: "+msg);
            Thread.sleep(1000);
        }

        channel.close();
        connection.close();
    }
}
