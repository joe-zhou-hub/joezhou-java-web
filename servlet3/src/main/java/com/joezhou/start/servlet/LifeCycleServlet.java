package com.joezhou.start.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet(value = "/api/life-cycle", loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
    @Override
    public void destroy() {
        System.out.println("destroy()...");
    }

    @Override
    public void init() {
        System.out.println("init()...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doGet()...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
