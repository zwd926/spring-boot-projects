package com.itcast.zwd.springboot.mapper.second;


import com.itcast.zwd.springboot.entity.second.SysConfig;

import java.util.List;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);

    List<SysConfig> selectActiveConfigs();
}