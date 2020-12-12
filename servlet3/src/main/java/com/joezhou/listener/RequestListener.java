package com.joezhou.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author JoeZhou
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        ServletRequest request = event.getServletRequest();
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.print("一个请求出生了...");
        System.out.println("URL是: " + req.getRequestURI());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        ServletRequest request = event.getServletRequest();
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.print("一个请求销毁了...");
        System.out.println("URL是: " + req.getRequestURI());
    }
}