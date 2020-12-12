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
        // 被添加的key和value
        System.out.print("请求域中添加了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        // 被替换的key和原来的value
        System.out.print("请求域中替换了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        // 被删除的key和value
        System.out.print("请求域中删除了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }
}