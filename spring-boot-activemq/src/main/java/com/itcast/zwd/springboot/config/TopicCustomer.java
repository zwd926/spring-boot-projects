package com.itcast.zwd.springboot.config;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * springboot整合mq
 * @author 随风逐梦
 * @create 2019-11-04 12:02
 */
@Component
public class TopicCustomer {
    /**
     * 创建2个消费者
     * @param text
     */
    @JmsListener(destination = "topic-my")
    public void subscriber(String text) {
        System.out.println("消费者1111111111111111111111消费+"+text);
    }

    @JmsListener(destination = "topic-my")
    public void subscriber1(String text) {
        System.out.println("消费者2222222222222222222222消费+"+text);
    }
}
