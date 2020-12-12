package com.joezhou.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author JoeZhou
 */
@WebListener
public class AnnotationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("AnnotationListener: contextInitialized()...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("AnnotationListener: contextDestroyed()...");
    }
}
