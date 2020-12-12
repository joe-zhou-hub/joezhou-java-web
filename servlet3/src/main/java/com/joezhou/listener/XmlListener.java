package com.joezhou.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author JoeZhou
 */
public class XmlListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("XmlListener: contextInitialized()...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("XmlListener: contextDestroyed()...");
    }
}
