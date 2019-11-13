package com.itcast.zwd.springboot.web;

import com.itcast.zwd.springboot.dto.ItemDto;
import com.itcast.zwd.springboot.enums.StatusCode;
import com.itcast.zwd.springboot.reponse.BaseResponse;
import com.itcast.zwd.springboot.service.FieldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 比较一个对象前后进行修改后的属性的变化
 * @author 随风逐梦
 * @create 2019-11-13 16:01
 */
@RestController
@RequestMapping(value = "/feild")
public class FeildController {

    private static final Logger log = LoggerFactory.getLogger(FeildController.class);


    @Autowired
    private FieldService fieldService;

    @RequestMapping(value = "/compare",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse compareFeilds(@RequestBody @Validated ItemDto dto, BindingResult result){
        if(result.hasErrors())
            return new BaseResponse(StatusCode.INVALIDPARAMS);

        BaseResponse response = new BaseResponse<>(StatusCode.SUCCESS);
        try {
            response.setData(fieldService.compare(dto));
        }catch (Exception e){
            response = new BaseResponse<>(StatusCode.FAIL.getCode(),e.getMessage());
        }
        return response;
    }

}
