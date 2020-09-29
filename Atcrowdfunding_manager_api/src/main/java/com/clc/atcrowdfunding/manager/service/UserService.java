package com.clc.atcrowdfunding.manager.service;

import com.clc.atcrowdfunding.bean.User;

import java.util.Map;

public interface UserService {
    User queryUserLogin(Map<String, Object> paramMap);
}
