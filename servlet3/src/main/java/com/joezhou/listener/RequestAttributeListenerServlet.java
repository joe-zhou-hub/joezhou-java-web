package com.joezhou.listener;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/request-attribute-listener")
public class RequestAttributeListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String meta = req.getParameter("meta");

        if (Meta.ADD.equals(meta)) {
            req.setAttribute("name", "admin");
            resp.getWriter().print("add success!");
        } else if (Meta.REPLACE.equals(meta)) {
            req.setAttribute("name", "admin");
            req.setAttribute("name", "joe");
            resp.getWriter().print("replace success!");
        } else if (Meta.REMOVE.equals(meta)) {
            req.setAttribute("name", "admin");
            req.removeAttribute("name");
            resp.getWriter().print("remove success!");
        }
    }

    interface Meta {
        String ADD = "add";
        String REPLACE = "replace";
        String REMOVE = "remove";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}