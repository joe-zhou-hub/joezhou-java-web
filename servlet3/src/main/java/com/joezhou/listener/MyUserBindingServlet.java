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
public class MyUserBindingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter("meta")) {
            case "bound":
                bound(req, resp);
                break;
            case "unbound":
                unbound(req, resp);
                break;
            default:
                throw new RuntimeException("meta error...");
        }
    }

    private void bound(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("myUser", new MyUser());
        resp.getWriter().print("myUser bound success!");
    }

    private void unbound(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("myUser");
        resp.getWriter().print("myUser unbound success!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}