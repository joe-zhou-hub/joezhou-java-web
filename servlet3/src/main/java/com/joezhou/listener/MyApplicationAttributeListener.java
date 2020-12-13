package com.joezhou.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @author JoeZhou
 */
@WebListener
public class MyApplicationAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("application add: " + event.getName() + "/" + event.getValue());
    }
    
    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        // old value
        System.out.println("application replace: " + event.getName() + "/" + event.getValue());

    }
    
    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("application remove: " + event.getName() + "/" + event.getValue());

    }
}