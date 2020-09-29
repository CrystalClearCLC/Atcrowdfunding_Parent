package com.clc.atcrowdfunding.test;

import com.clc.atcrowdfunding.manager.service.AccountService;
import org.testng.annotations.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test1(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:Spring/applicationContext.xml");
        //获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        //调用方法
        as.findAll();
    }

}
