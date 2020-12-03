package com.joezhou.start.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet(value = "/api/servlet_config_annotation", initParams = {
        @WebInitParam(name = "tel", value = "17766541438"),
        @WebInitParam(name = "email", value = "yy06200210@qq.com"),
})
public class ServletConfigAnnotationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(super.getServletConfig().getInitParameter("tel"));
        System.out.println(super.getServletConfig().getInitParameter("email"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
