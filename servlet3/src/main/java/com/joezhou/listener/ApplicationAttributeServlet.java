package com.joezhou.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/applicationAttributeListener")
public class ApplicationAttributeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String meta = req.getParameter("meta");
        String create = "create";
        String replace = "replace";
        String remove = "remove";
        if (create.equals(meta)) {
            ServletContext application = req.getServletContext();
            application.setAttribute("applicationKey", "applicationValue");
        }
        if (replace.equals(meta)) {
            ServletContext application = req.getServletContext();
            application.setAttribute("applicationKey", "applicationValue2");
        }
        if (remove.equals(meta)) {
            ServletContext application = req.getServletContext();
            application.removeAttribute("applicationKey");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.doGet(req, resp);
    }
}