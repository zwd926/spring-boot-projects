package com.itcast.zwd.springboot.service.impl;

import com.github.dadiyang.equator.Equator;
import com.github.dadiyang.equator.FieldInfo;
import com.itcast.zwd.springboot.dto.ItemDto;
import com.itcast.zwd.springboot.entity.primary.CompareLog;
import com.itcast.zwd.springboot.entity.primary.Item;
import com.itcast.zwd.springboot.enums.ItemCompareEnum;
import com.itcast.zwd.springboot.mapper.primary.CompareLogMapper;
import com.itcast.zwd.springboot.mapper.primary.ItemMapper;
import com.itcast.zwd.springboot.service.FieldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 随风逐梦
 * @create 2019-11-13 16:15
 */
@Service
public class FieldServiceImpl implements FieldService {

    private static final Logger log = LoggerFactory.getLogger(FieldServiceImpl.class);
    private static final SimpleDateFormat FORMAT=new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private Equator equator;

    @Override
    public List<FieldInfo> compare(ItemDto dto) throws ParseException {
        log.info("新对象：{}",dto);
        Item entity = itemMapper.selectByPrimaryKey(dto.getId());
        ItemDto old = new ItemDto();
        BeanUtils.copyProperties(entity,old);
        entity.setPurchaseTime(FORMAT.parse(dto.getPurchaseTime()));
        log.info("旧对象：{}",old);

        //执行更新
        BeanUtils.copyProperties(dto,entity);
        entity.setUpdateTime(new Date());
        entity.setPurchaseTime(FORMAT.parse(dto.getPurchaseTime()));
        itemMapper.updateByPrimaryKey(entity);

        //执行对象比较
        List<FieldInfo> infos = equator.getDiffFields(old, dto);
        log.info("比较结果：{}",infos);

        //记录对比结果
        this.logCompareResult(infos);
        return infos;
    }

    @Autowired
    private CompareLogMapper compareLogMapper;

    private void logCompareResult(List<FieldInfo> infos) {
        if(infos!=null && !infos.isEmpty()){
            infos.stream().forEach(info ->{
                CompareLog compareLog = new CompareLog();
                compareLog.setCode(info.getFieldName());
                compareLog.setName(String.valueOf(ItemCompareEnum.getFieldMap().get(info.getFieldName())));
                compareLog.setOldVal(String.valueOf(info.getFirstVal()));
                compareLog.setNewVal(String.valueOf(info.getSecondVal()));
                compareLog.setCreateTime(new Date());
                compareLogMapper.insert(compareLog);
            });
        }
    }
}
