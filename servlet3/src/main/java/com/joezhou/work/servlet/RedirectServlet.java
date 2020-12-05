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

        String meta = req.getParameter("meta");
        if (Meta.WEB_APP_RES.equals(meta)) {
            webAppRes(req, resp);
        } else if (Meta.WEB_INF_RES.equals(meta)) {
            webInfRes(req, resp);
        }
    }

    interface Meta {
        String WEB_APP_RES = "web-app-res";
        String WEB_INF_RES = "web-inf-res";
    }

    private void webAppRes(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("重定向到/view/html/login.html");
        resp.sendRedirect(req.getContextPath() + "/view/html/login.html");
    }

    private void webInfRes(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("重定向到/WEB-INF/web-inf-res.html");
        resp.sendRedirect(req.getContextPath() + "/web-inf-res");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
