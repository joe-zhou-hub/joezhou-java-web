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
@WebServlet("/servlet/requestAttributeListener")
public class RequestAttributeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String meta = req.getParameter("meta");
        String add = "add";
        String replace = "replace";
        String remove = "remove";
        if (add.equals(meta)) {
            req.setAttribute("requestKey", "requestValue");
        }
        if (replace.equals(meta)) {
            req.setAttribute("requestKey", "requestValue");
            req.setAttribute("requestKey", "requestValue2");
        }
        if (remove.equals(meta)) {
            req.setAttribute("requestKey", "requestValue");
            req.removeAttribute("requestKey");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        this.doGet(req, resp);
    }
}