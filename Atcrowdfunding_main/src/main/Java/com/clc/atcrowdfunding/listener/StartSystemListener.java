package com.clc.atcrowdfunding.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 功能描述自定义监听器
 * @Param:
 * @Return: 
 * @Author: 10855
 * @Date: 2020/4/1 16:13
 */
public class StartSystemListener implements ServletContextListener {

    //在服务器启动时创建applicaation对象是需要只想的方法
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //将项目上下文路径放置到application中
        ServletContext servletContext = servletContextEvent.getServletContext();
        String contextPath = servletContext.getContextPath();
        servletContext.setAttribute("APP_PATH",contextPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
