package com.itcast.zwd.springboot.springbootaoplog.web;

import com.itcast.zwd.springboot.springbootaoplog.annotation.LogAnnotation;
import com.itcast.zwd.springboot.springbootaoplog.entity.LogUpdateDto;
import com.itcast.zwd.springboot.springbootaoplog.entity.User;
import com.itcast.zwd.springboot.springbootaoplog.enums.StatusCode;
import com.itcast.zwd.springboot.springbootaoplog.mapper.UserMapper;
import com.itcast.zwd.springboot.springbootaoplog.reponse.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 随风逐梦
 * @create 2019-11-13 12:36
 */
@RestController
public class LogController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/update",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @LogAnnotation(value = "测试添加日志")
    public BaseResponse update(@RequestBody LogUpdateDto dto){
        BaseResponse response=new BaseResponse(StatusCode.SUCCESS);

        User user=new User();
        user.setName(dto.getName());
        user.setCode(dto.getCode());
        userMapper.insertSelective(user);

        return response;
    }
}
