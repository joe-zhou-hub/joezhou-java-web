package com.joezhou.work.servlet;

import javax.servlet.ServletContext;
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
@WebServlet("/api/store")
public class StoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String meta = req.getParameter("meta");
        if (Meta.REQUEST.equals(meta)) {
            request(req, resp);
        } else if (Meta.SESSION.equals(meta)) {
            session(req, resp);
        } else if (Meta.APPLICATION.equals(meta)) {
            application(req, resp);
        }
    }

    interface Meta {
        String REQUEST = "request";
        String SESSION = "session";
        String APPLICATION = "application";
    }

    private void request(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setAttribute("req-name", "req-value-1");
        req.setAttribute("req-name", "req-value-2");
        System.out.println(req.getAttribute("req-name"));
        System.out.println(req.getAttribute("abc"));
        resp.getWriter().print("request: " + req.getAttribute("req-name"));
    }

    private void session(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        System.out.println(session.isNew() ? "session is new..." : "session is old...");
        System.out.println("sessionId: " + session.getId());
        System.out.println("inactiveInterval: " + session.getMaxInactiveInterval());
        session.setMaxInactiveInterval(3600);
        System.out.println("inactiveInterval: " + session.getMaxInactiveInterval());
        session.setAttribute("session-name", "session-value-1");
        session.setAttribute("session-name", "session-value-2");
        System.out.println(session.getAttribute("session-name"));
        System.out.println(session.getAttribute("abc"));
        resp.getWriter().print("session: " + session.getAttribute("session-name"));
    }

    private void application(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext application = req.getServletContext();
        application.setAttribute("application-name", "application-value-1");
        application.setAttribute("application-name", "application-value-2");
        System.out.println(application.getAttribute("application-name"));
        System.out.println(application.getAttribute("abc"));
        resp.getWriter().print("application: " + application.getAttribute("application-name"));
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
