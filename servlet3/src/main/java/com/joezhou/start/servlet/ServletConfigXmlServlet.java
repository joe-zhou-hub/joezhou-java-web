package com.joezhou.start.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
public class ServletConfigXmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tel = super.getServletConfig().getInitParameter("tel");
        System.out.println(tel);
        String email = super.getServletConfig().getInitParameter("email");
        System.out.println(email);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().print(tel + " : " + email);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
