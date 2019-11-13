package com.itcast.zwd.springboot.service.impl;

import com.itcast.zwd.springboot.service.IBaseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 随风逐梦
 * @create 2019-11-13 10:16
 */
@Service
public class IBaseServiceImpl implements IBaseService {
    static Map<Integer,String> products;
    static
    {
        products = new HashMap<>();
        products.put(1, "springboot第四版");
    }


    @Override
    public String getItem(Integer id) {
     return products.get(id);
    }
}
