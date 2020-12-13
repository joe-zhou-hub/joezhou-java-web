package com.joezhou.listener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/my-session-binding")
public class MySessionBindingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String meta = req.getParameter("meta");
        User user = new User();

        if (Meta.BOUND.equals(meta)) {
            req.getSession().setAttribute("user", user);
            resp.getWriter().print("bound success!");
        } else if (Meta.UNBOUND.equals(meta)) {
            req.getSession().removeAttribute("user");
            resp.getWriter().print("unbound success!");
        }
    }

    interface Meta {
        String BOUND = "bound";
        String UNBOUND = "unbound";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}