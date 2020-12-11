package com.joezhou.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebFilter("/api/*")
public class IllegalRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("IllegalLoginFilter init()...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        final String effectivePath = "/api/login";
        if (req.getRequestURI().contains(effectivePath) || isLoggedIn(req, resp)) {
            chain.doFilter(req, resp);
        } else {
            resp.getWriter().println("{\"message\":\"非法登陆！\"}");
        }
    }

    private boolean isLoggedIn(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session;
        synchronized (session = req.getSession()) {
            return session.getAttribute("name") != null;
        }
    }

    @Override
    public void destroy() {
        System.out.println("IllegalLoginFilter destroy()...");
    }
}