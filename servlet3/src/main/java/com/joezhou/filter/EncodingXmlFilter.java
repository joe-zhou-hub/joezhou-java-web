package com.joezhou.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author JoeZhou
 **/
public class EncodingXmlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("EncodingXmlFilter init()...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        before(req, resp);
        chain.doFilter(req, resp);
        after();
    }

    private void before(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        System.out.println("EncodingXmlFilter: before service()...");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
    }

    private void after() {
        System.out.println("EncodingXmlFilter: after service()...");
    }

    @Override
    public void destroy() {
        System.out.println("EncodingXmlFilter destroy()...");
    }
}