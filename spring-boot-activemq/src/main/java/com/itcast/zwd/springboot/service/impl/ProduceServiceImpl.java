package com.itcast.zwd.springboot.service.impl;

import com.itcast.zwd.springboot.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * spring整合mq
 * @author 随风逐梦
 * @create 2019-11-04 11:02
 */
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name="queueDestination")
    private Destination destination;

    @Override
    public void sendMessage(final String msg) {
        jmsTemplate.send(destination,new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(msg);
                return textMessage;
            }
        });
        System.out.print("现在发送的消息是:"+msg);
    }
}
