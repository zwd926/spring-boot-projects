package com.itcast.zwd.springboot.web;

import com.itcast.zwd.springboot.enums.StatusCode;
import com.itcast.zwd.springboot.mapper.primary.UserMapper;
import com.itcast.zwd.springboot.mapper.second.SysConfigMapper;
import com.itcast.zwd.springboot.reponse.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * springboot整合mybatis多数据源
 * @author 随风逐梦
 * @create 2019-11-13 14:38
 */
@RestController
public class multipleController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @GetMapping("/list")
    public BaseResponse list(){
        BaseResponse response = new BaseResponse<>(StatusCode.SUCCESS);
        Map<String, Object> map;
        map = new HashMap();
        try {
            map.put("主数据源",userMapper.selectByPrimaryKey(6));
            map.put("从数据源",sysConfigMapper.selectActiveConfigs());
        }catch (Exception e){
            response = new BaseResponse(StatusCode.FAIL.getCode(),e.getMessage());
        }
        response.setData(map);
        return response;
    }


}

