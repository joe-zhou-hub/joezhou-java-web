package com.joezhou.listener;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/my-session-attribute")
public class MySessionAttributeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        switch (req.getParameter("meta")) {
            case "add":
                add(req, resp);
                break;
            case "replace":
                replace(req, resp);
                break;
            case "remove":
                remove(req, resp);
                break;
            default:
                throw new RuntimeException("meta error...");
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("name", "admin");
        resp.getWriter().print("add success!");
    }

    private void replace(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("name", "admin");
        req.getSession().setAttribute("name", "joe");
        resp.getWriter().print("replace success!");
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("name", "admin");
        req.getSession().removeAttribute("name");
        resp.getWriter().print("remove success!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}