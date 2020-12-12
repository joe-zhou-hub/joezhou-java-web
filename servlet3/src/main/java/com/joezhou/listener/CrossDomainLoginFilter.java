package com.joezhou.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author JoeZhou
 */
@WebFilter("/api/cross-domain-login")
public class CrossDomainLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("CrossDomainLoginFilter: init()...");
    }

    @SuppressWarnings("all")
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String name = req.getParameter("name");

        ServletContext application;
        synchronized (application = req.getServletContext()) {
            List<String> onlineUsers = (List<String>) application.getAttribute("onlineUsers");
            if (onlineUsers.isEmpty() || !onlineUsers.contains(name)) {
                chain.doFilter(req, resp);
            } else {
                resp.getWriter().print("{\"message\":\"" + name + "已登录！\"}");
            }
        }

    }

    @Override
    public void destroy() {
        System.out.println("CrossDomainLoginFilter: destroy()...");
    }
}