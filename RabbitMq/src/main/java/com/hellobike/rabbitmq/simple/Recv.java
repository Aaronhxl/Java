package com.hellobike.rabbitmq.simple;

import com.hellobike.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消息发送方
 */
public class Recv {
    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        //创建频道
        Channel channel = connection.createChannel();
        //队列声明
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DefaultConsumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("new api recv:" + msg);
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);


    }

//    private  void oldApi() throws IOException, TimeoutException, InterruptedException {
//        //获取一个连接
//        Connection connection = ConnectionUtils.getConnection();
//        //从连接中获取一个通道
//        Channel channel = connection.createChannel();
//        //定义队列的消费者
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//        //监听队列
//        channel.basicConsume(QUEUE_NAME, true,consumer);
//        while (true){
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String msgString = new String(delivery.getBody());
//            System.out.println("{recv} msg:"+msgString);
//        }
//    }

}
