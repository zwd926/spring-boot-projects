package com.itcast.zwd.springboot.springbootaoplog.mapper;


import com.itcast.zwd.springboot.springbootaoplog.entity.SysLog;

public interface SysLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}