package com.itcast.zwd.springboot.mapper.primary;


import com.itcast.zwd.springboot.entity.primary.CompareLog;

public interface CompareLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompareLog record);

    int insertSelective(CompareLog record);

    CompareLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompareLog record);

    int updateByPrimaryKey(CompareLog record);
}