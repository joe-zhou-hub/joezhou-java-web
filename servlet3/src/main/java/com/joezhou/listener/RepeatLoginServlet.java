package com.joezhou.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author JoeZhou
 */
@WebServlet("/api/repeat-login")
public class RepeatLoginServlet extends HttpServlet {
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

    @SuppressWarnings("all")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // suppose login success

        String name = req.getParameter("name");
        ServletContext application;
        synchronized (application = req.getServletContext()) {
            List<String> onlineUsers = (List<String>) application.getAttribute("onlineUsers");
            onlineUsers.add(name);
            application.setAttribute("onlineUsers", onlineUsers);
        }
        resp.getWriter().print(name + "登录...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}