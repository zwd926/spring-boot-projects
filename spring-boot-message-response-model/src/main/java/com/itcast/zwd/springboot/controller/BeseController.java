package com.itcast.zwd.springboot.controller;

import com.itcast.zwd.springboot.enums.StatusCode;
import com.itcast.zwd.springboot.reponse.BaseResponse;
import com.itcast.zwd.springboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 随风逐梦
 * @create 2019-11-13 10:04
 */
@RestController
@RequestMapping(value = "/base")
public class BeseController {
    @Autowired
    private IBaseService iBaseService;


    /**
     * 获取基本的信息
     * @param name
     * @return
     */
    @GetMapping(value = "/info")
    public BaseResponse info(String name){
        BaseResponse response = new BaseResponse<>(StatusCode.SUCCESS);
        try {
            if(StringUtils.isEmpty(name)){
                name = "随风逐梦";
            }
            response.setData(name);
        }catch (Exception e){
            response = new BaseResponse(StatusCode.FAIL.getCode(),e.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/getInfo")
    public BaseResponse item(@RequestParam(required = false,defaultValue = "1") Integer id){
        BaseResponse response = new BaseResponse<>(StatusCode.SUCCESS);
        try {
            response.setData(iBaseService.getItem(id));
        }catch (Exception e){
            response = new BaseResponse(StatusCode.FAIL.getCode(),e.getMessage());
        }
        return  response;

    }

}
