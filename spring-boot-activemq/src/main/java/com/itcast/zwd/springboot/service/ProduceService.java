package com.itcast.zwd.springboot.service;

/**
 * spring整合mq
 * @author 随风逐梦
 * @create 2019-11-04 11:01
 */
public interface ProduceService {
    void sendMessage(String msg);
}
