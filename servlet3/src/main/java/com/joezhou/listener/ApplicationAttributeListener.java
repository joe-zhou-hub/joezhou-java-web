package com.joezhou.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        // 添加的key和value
        System.out.print("服务域中添加了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }
    
    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        // 获取的是替换的新Key，和原来的旧value
        System.out.print("服务域中替换了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }
    
    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        // 删除的key和value
        System.out.print("服务域中删除了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }
}