package com.joezhou.start;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/servlet-context")
public class ServletContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loc = super.getServletContext().getInitParameter("loc");
        System.out.println(loc);
        String type = super.getServletContext().getInitParameter("type");
        System.out.println(type);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().print(loc + " : " + type);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
