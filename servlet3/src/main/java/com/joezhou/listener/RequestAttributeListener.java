package com.joezhou.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @author JoeZhou
 */
@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.print("RequestAttributeListener: attributeAdded()...");
        System.out.println(event.getName() + " : " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {

        // value is old...
        System.out.print("RequestAttributeListener: attributeReplaced()...");
        System.out.println(event.getName() + ":" + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.print("RequestAttributeListener: attributeRemoved()...");
        System.out.println(event.getName() + ":" + event.getValue());
    }
}