package com.clc.atcrowdfunding.manager.service.impl;

import com.clc.atcrowdfunding.bean.Account;
import com.clc.atcrowdfunding.manager.dao.AccountDao;
import com.clc.atcrowdfunding.manager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 功能描述
 * @Param:
 * @Return: 
 * @Author: 10855
 * @Date: 2020/3/31 21:51
 *
 * @Autowired 注入 先按类型（类名）byType
 * 找到一个，直接注入
 * 找到多个  再按名称byName（与变量名称相同）
 * 如果没有名称一致
 * 可以指定@Qualifier（value="beanName"）一个注入进来
 * 如果指定名称仍然没有对应的Bean 报错
 * 不想报错 @Autowired（requied=false）直接不注入
 *
 * AOP原理动态代理
 * 如果目标有接口  么人采用JDK动态代理（基于接口（代理类和目标类共同实现一个接口））
 * 没有接口  采用Cglib动态代理（基于继承（代理类是目标类的子类））
 * 推荐JDK  也就是面向接口面呈（面向抽象）
 */
@Service("accountService")
public class AcountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;
    @Override
    public List<Account> findAll(){
        System.out.println("service");
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        return list;
    }
}
