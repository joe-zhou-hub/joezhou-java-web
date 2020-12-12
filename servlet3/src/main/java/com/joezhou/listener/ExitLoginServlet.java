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
@WebServlet("/api/exit-login")
public class ExitLoginServlet extends HttpServlet {

    @SuppressWarnings("all")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        ServletContext application;
        synchronized (application = req.getServletContext()){
            List<String> onlineUsers = (List<String>) application.getAttribute("onlineUsers");
            onlineUsers.remove(name);
            application.setAttribute("onlineUsers", onlineUsers);
            resp.getWriter().print("{\"message\":\"" + name + "退出登陆！\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}