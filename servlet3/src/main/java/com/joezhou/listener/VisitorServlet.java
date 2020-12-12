package com.joezhou.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/visitor")
public class VisitorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String meta = req.getParameter("meta");

        if (Meta.LOGIN.equals(meta)) {
            // Hypothesis login success
            String name = req.getParameter("name");
            HttpSession session;
            synchronized (session = req.getSession()) {
                session.setAttribute("name", req.getParameter("name"));
            }
            ServletContext application;
            synchronized (application = req.getServletContext()) {
                int visitorCount = (int) application.getAttribute("visitorCount");
                application.setAttribute("visitorCount", ++visitorCount);
                System.out.println("当前第" + visitorCount + "个人登录了您的网站！");
            }
            resp.getWriter().print("{\"name\":" + name + "}");
        }
    }

    interface Meta {
        String LOGIN = "login";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}