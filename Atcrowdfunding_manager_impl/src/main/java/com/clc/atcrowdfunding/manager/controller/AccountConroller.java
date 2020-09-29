package com.clc.atcrowdfunding.manager.controller;


import com.clc.atcrowdfunding.bean.Account;
import com.clc.atcrowdfunding.manager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountConroller {
    @Autowired
    AccountService accountService;
    @RequestMapping("/findAll.do")
    public String findAll(){
        System.out.println("Controller");
        accountService.findAll();
        return "list";
    }
}
