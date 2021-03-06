package com.itcast.zwd.springboot.controller.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 队列模型之消费者
 * @author 随风逐梦
 * @create 2019-11-08 14:49
 */
public class MessageConsumer2 {
    //定义activemq的链接地址
    private static final String ACTIVEMQ_USL = "tcp://127.0.0.1:61616";
    //定义发送消息的队列名称
    private static final String QUEUE_NAME="MyMessage";

    public static void main(String[] args) throws JMSException {
        //链接工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_USL);
        //创建链接
        Connection connection = factory.createConnection();
        //打开链接
        connection.start();
        //创建回话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Queue queue = session.createQueue(QUEUE_NAME);
        //创建一个生产者
        javax.jms.MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("获取消息:"+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
