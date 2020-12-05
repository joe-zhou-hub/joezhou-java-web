package com.joezhou.work.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/ajax")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");

        String meta = req.getParameter("meta");
        if (Meta.AJAX_TYPE.equals(meta)) {
            ajaxType(req, resp);
        }
    }

    interface Meta {
        String AJAX_TYPE = "ajax_type";
        String XML_HTTP_REQUEST = "XMLHttpRequest";
    }

    private void ajaxType(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String xRequestedWith = req.getHeader("x-requested-with");
        if (xRequestedWith != null && xRequestedWith.equals(Meta.XML_HTTP_REQUEST)) {
            System.out.println("本次请求是AJAX请求，使用IO回写...");
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().print("数据");
        } else {
            System.out.println("本次请求不是AJAX请求，使用请求转发...");
            req.getRequestDispatcher("/view/html/login.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
