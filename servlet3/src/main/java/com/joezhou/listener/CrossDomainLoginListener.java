package com.joezhou.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

/**
 * @author JoeZhou
 *
 */
@WebListener
public class CrossDomainLoginListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("onlineUsers", new ArrayList<>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        event.getServletContext().removeAttribute("onlineUsers");
    }
}