package com.joezhou.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/visitor-count")
public class VisitorCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String meta = req.getParameter("meta");

        if (Meta.LOGIN.equals(meta)) {
            login(req, resp);
        }

    }

    interface Meta {
        String LOGIN = "login";
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // suppose login success

        ServletContext application;
        int visitorCount;
        synchronized (application = req.getServletContext()) {
            visitorCount = (int) application.getAttribute("visitorCount");
            application.setAttribute("visitorCount", ++visitorCount);
        }
        resp.getWriter().print("{\"message\":\"当前第" + visitorCount + "个人登录了您的网站！\"}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}