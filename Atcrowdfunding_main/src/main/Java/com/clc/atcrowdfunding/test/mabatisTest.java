package com.clc.atcrowdfunding.test;
import java.io.InputStream;
import java.util.List;


import com.clc.atcrowdfunding.bean.Account;
import com.clc.atcrowdfunding.manager.dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class mabatisTest {
    @Test
    public void run1() throws Exception {
// 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("Mybatis/SqlMapConfig.xml");
// 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
// 创建sqlSession对象
        SqlSession session = factory.openSession();
// 获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
// 调用查询的方法
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
// 释放资源
        session.close();
        inputStream.close();
    }
    @Test
    public void run2() throws Exception {
        Account account = new Account();
        account.setName("熊大");
        account.setMoney(400d);
// 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("Mybatis/SqlMapConfig.xml");
// 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
// 创建sqlSession对象
        SqlSession session = factory.openSession();
// 获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        dao.saveAccount(account);
// 提交事务
        session.commit();
// 释放资源
        session.close();
        inputStream.close();
    }
}
