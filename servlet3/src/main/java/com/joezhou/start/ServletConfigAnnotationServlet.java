package com.joezhou.start;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet(value = "/api/servlet-config-annotation", initParams = {
        @WebInitParam(name = "username", value = "joezhou"),
        @WebInitParam(name = "password", value = "12345"),
})
public class ServletConfigAnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = super.getServletConfig().getInitParameter("username");
        System.out.println(username);
        String password = super.getServletConfig().getInitParameter("password");
        System.out.println(password);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().print(username + " : " + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
