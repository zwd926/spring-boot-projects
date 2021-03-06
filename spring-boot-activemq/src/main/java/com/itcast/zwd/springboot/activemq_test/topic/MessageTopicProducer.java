package com.itcast.zwd.springboot.activemq_test.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**主题模型之生产者
 * @author 随风逐梦
 * @create 2019-11-04 10:08
 * 主题模型是所有的消费者共享所有的消息  不会独自占有
 * 消费者如果是在生产者之后过来  则不会消费已经生产过之后的消息
 */
public class MessageTopicProducer {
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
        Topic topic = session.createTopic(QUEUE_NAME);
        //创建一个生产者
        javax.jms.MessageProducer producer = session.createProducer(topic);
        //创建模拟100个消息
        for (int i=1;i<=10;i++){
            TextMessage textMessage = session.createTextMessage("我发送的message:" + i);
            //发送消息
            producer.send(textMessage);
            //本地打印消息
            System.out.println("我现在发的消息是："+textMessage.getText());
        }
        //关闭链接
        connection.close();

    }
}
