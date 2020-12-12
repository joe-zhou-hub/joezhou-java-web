package com.joezhou.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext application = event.getServletContext();
        System.out.print("一个应用出生了，通过它获取到项目名...");
        System.out.println(application.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        ServletContext application = event.getServletContext();
        System.out.print("一个应用出生了，通过它获取到项目名...");
        System.out.println(application.getContextPath());
    }
}