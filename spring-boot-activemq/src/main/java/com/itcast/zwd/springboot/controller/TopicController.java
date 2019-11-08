package com.itcast.zwd.springboot.controller;

import com.itcast.zwd.springboot.config.TopicProducter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring整合mq
 * @author 随风逐梦
 * @create 2019-11-04 12:03
 */
@RestController
public class TopicController {
    @Autowired
    private TopicProducter topicProducter;

    @GetMapping("/publish")
    public String publish(String msg) {
        topicProducter.sendMessage(msg);
        return "消息已经发布";
    }
}
