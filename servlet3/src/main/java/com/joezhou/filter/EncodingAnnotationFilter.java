package com.joezhou.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 **/
@WebFilter("/api/*")
public class EncodingAnnotationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("EncodingAnnotationFilter init()...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("EncodingAnnotationFilter: before service()...");
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        chain.doFilter(req, resp);
        System.out.println("EncodingAnnotationFilter: after service()...");
    }

    @Override
    public void destroy() {
        System.out.println("EncodingAnnotationFilter destroy()...");
    }
}