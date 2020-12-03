package com.joezhou.work.servlet;

import com.joezhou.work.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        final String LOGIN = "login";

        String meta = req.getParameter("meta");
        if (LOGIN.equals(meta)) {
            login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean result = new AccountServiceImpl().login(username, password);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(result ? username + " 登陆成功..." : username + " 登陆失败...");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
