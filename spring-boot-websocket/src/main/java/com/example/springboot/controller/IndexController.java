package com.example.springboot.controller;

import com.example.springboot.websocket.WebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 随风逐梦
 * @create 2019-10-31 15:47
 */
@Controller
public class IndexController {
    @GetMapping(value = "/")
    @ResponseBody
    public Object index() {

        return "Hello,ALl。This is yuanmayouchuang webSocket demo！";
    }

    @ResponseBody
    @GetMapping("test")
    public String test(String userId, String message) throws Exception {
        if (userId == "" || userId == null) {
            return "发送用户id不能为空";
        }
        if (message == "" || message == null) {
            return "发送信息不能为空";
        }
        new WebSocket().systemSendToUser(userId, message);
        return "发送成功！";
    }

    @RequestMapping(value = "/ws")
    public String ws() {
        return "ws";
    }

    @RequestMapping(value = "/ws1")
    public String ws1() {
        return "ws1";
    }
}
