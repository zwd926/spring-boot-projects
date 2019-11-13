package com.itcast.zwd.springboot.service;

import com.github.dadiyang.equator.FieldInfo;
import com.itcast.zwd.springboot.dto.ItemDto;

import java.text.ParseException;
import java.util.List;

/**
 * @author 随风逐梦
 * @create 2019-11-13 16:09
 */
public interface FieldService {

    List<FieldInfo> compare(ItemDto dto) throws ParseException;
}
