package com.joezhou.filter;

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
@WebServlet("/api/illegal-request")
public class IllegalRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // suppose login success

        HttpSession session;
        synchronized (session = req.getSession()) {
            session.setAttribute("name", req.getParameter("name"));
        }

        resp.getWriter().print("{\"message\":\"登陆成功！\"}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
