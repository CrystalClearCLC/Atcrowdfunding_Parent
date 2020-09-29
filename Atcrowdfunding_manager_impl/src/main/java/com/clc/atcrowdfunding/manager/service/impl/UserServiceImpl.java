package com.clc.atcrowdfunding.manager.service.impl;

import com.clc.atcrowdfunding.bean.User;
import com.clc.atcrowdfunding.manager.dao.UserMapper;
import com.clc.atcrowdfunding.manager.service.UserService;
import com.clc.atcrowdfunding.util.LoginFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User queryUserLogin(Map<String, Object> paramMap) {
        User user=userMapper.queryUserLogin(paramMap);

        if(user==null){
            throw new LoginFailException("登陆失败");
        }else {
            System.out.println(user);
        }
        return user;
    }
}
