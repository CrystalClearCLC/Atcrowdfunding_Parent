package com.clc.atcrowdfunding.manager.dao;

import com.clc.atcrowdfunding.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    @Select("select id,loginacct, userpswd, username, email, createtime from t_user where loginacct=#{username} and userpswd=#{password}")
	User queryUserLogin(Map<String, Object> paramMap);
}