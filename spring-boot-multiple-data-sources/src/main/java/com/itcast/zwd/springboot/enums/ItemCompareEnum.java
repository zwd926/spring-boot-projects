package com.itcast.zwd.springboot.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 随风逐梦
 * @create 2019-11-13 16:29
 */
public class ItemCompareEnum {
    private static Map<String,Object> fieldMap;

    static{
        fieldMap=new LinkedHashMap<>();
        fieldMap.put("name","商品名称");
        fieldMap.put("code","商品编码");
        fieldMap.put("stock","商品库存");
        fieldMap.put("purchaseTime","采购时间");
        fieldMap.put("isActive","是否有效");
    }

    public static Map<String,Object> getFieldMap(){
        return fieldMap;
    }
}
