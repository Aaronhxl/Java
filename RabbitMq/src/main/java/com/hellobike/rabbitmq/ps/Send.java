package com.hellobike.rabbitmq.ps;

import com.hellobike.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 订阅模式的演示
 */
public class Send {

    private static final String EXCHANGE_NAME = "test_exchange_fanout";
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        //获取频道
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        //发送
        String msg = "hello ps";
        channel.basicPublish(EXCHANGE_NAME, "",null , msg.getBytes());
        System.out.println("Send :"+msg);

        channel.close();
        connection.close();
    }
}
