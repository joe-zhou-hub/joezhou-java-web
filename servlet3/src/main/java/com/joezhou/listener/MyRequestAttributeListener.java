package com.joezhou.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @author JoeZhou
 */
@WebListener
public class MyRequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("request add: " + event.getName() + "/" + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        // value is old...
        System.out.println("request replace: " + event.getName() + "/" + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("request remove: " + event.getName() + "/" + event.getValue());
    }
}