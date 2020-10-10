package com.clc.atcrowdfunding.manager.service.impl;

import com.clc.atcrowdfunding.bean.User;
import com.clc.atcrowdfunding.manager.dao.RegisterDAO;
import com.clc.atcrowdfunding.manager.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017-2020
 * Author: CrystalClear
 * Date: 2020/10/10 18:34
 * FileName: RegisterServiceImpl
 * Description: RegisterServiceImpl
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterDAO registerDAO;

    @Override
    public void register(User user) {
        System.out.println("user:"+user.getLoginacct());
        User u =registerDAO.findUserByLoginacct(user.getLoginacct());
        System.out.println("u:"+u);
    }
}
