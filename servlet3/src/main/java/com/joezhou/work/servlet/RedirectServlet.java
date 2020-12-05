package com.joezhou.work.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        //System.out.println("重定向到/view/html/login.html");
        //resp.sendRedirect(req.getContextPath() + "/view/html/login.html");

        System.out.println("重定向到/WEB-INF/web-inf-res.html");
        resp.sendRedirect(req.getContextPath() + "/web-inf-res");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
