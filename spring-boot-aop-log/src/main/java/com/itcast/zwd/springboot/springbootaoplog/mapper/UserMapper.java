package com.itcast.zwd.springboot.springbootaoplog.mapper;



import com.itcast.zwd.springboot.springbootaoplog.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<Integer> selectAllIds();

    List<User> selectByIds(List<Integer> list);

    List<User> selectByStrIds(@Param("ids") String ids);

    Set<String> selectAllUserEmails();

    void insertCode(@Param("itemId") Integer itemId);
}