package com.joezhou.work.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author JoeZhou
 */
@WebServlet("/api/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("param: " + req.getParameter("username"));
        System.out.println("params: " + Arrays.toString(req.getParameterValues("id")));
        System.out.println("uri: " + req.getRequestURI());
        System.out.println("url: " + req.getRequestURL());
        System.out.println("serverName: " + req.getServerName());
        System.out.println("serverPort: " + req.getServerPort());
        System.out.println("contextPath: " + req.getContextPath());
        System.out.println("servletPath: " + req.getServletPath());
        System.out.println("queryString: " + req.getQueryString());
        System.out.println("userAgent: " + req.getHeader("User-Agent"));
        for (Cookie cookie : req.getCookies()) {
            System.out.println(cookie.getName() + "-" + cookie.getValue());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
