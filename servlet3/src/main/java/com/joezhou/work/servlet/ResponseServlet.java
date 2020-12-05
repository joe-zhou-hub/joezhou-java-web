package com.joezhou.work.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/response")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie cookie = new Cookie("cookie-name", "cookie-value");
        cookie.setMaxAge(60 * 5);
        resp.addCookie(cookie);
        System.out.println(resp.containsHeader("string-header"));
        resp.addHeader("string-header", "string-header");
        System.out.println(resp.containsHeader("string-header"));
        resp.addIntHeader("int-header", 9527);
        resp.addDateHeader("date-header", System.currentTimeMillis());
        resp.setContentLength(1);
        resp.setStatus(200);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().print("response-data");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
