package com.clc.atcrowdfunding.manager.dao;

import com.clc.atcrowdfunding.bean.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 功能描述:持久层接口
 * @Param:
 * @Return:
 * @Author: 10855
 * @Date: 2020/3/17 15:23
 */
@Repository
public interface AccountDao {
    @Insert(value="insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);
    @Select("select * from account")
    public List<Account> findAll();
}
