package com.joezhou.listener;

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
@WebServlet("/api/my-session")
public class MySessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String meta = req.getParameter("meta");
        HttpSession session;
        if (Meta.CREATE.equals(meta)) {
            session = req.getSession();
            resp.getWriter().print("session create success: " + session.getId());
        } else if (Meta.DESTROY.equals(meta)) {
            session = req.getSession();
            session.invalidate();
            resp.getWriter().print("session destroy success: " + session.getId());
        }
    }

    interface Meta {
        String CREATE = "create";
        String DESTROY = "destroy";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
