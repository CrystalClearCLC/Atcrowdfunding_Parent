package com.clc.atcrowdfunding.controller;

import com.clc.atcrowdfunding.bean.User;
import com.clc.atcrowdfunding.manager.service.RegisterService;
import com.clc.atcrowdfunding.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Copyright (C), 2017-2020
 * Author: CrystalClear
 * Date: 2020/10/10 14:05
 * FileName: RegisterController
 * Description: RegisterController
 */
@Controller
public class RegisterController {

    @Autowired
    RegisterService RegisterServiceImpl;

    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    public void register(User user) {
        user.setUserpswd(MD5Util.digest(user.getUserpswd()));

        RegisterServiceImpl.register(user);
    }
}
