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
        String xRequestedWith = req.getHeader("x-requested-with");
        String ajaxType = "XMLHttpRequest";
        if (ajaxType.equals(xRequestedWith)) {
            System.out.println("本次请求是AJAX请求，回写JSON数据...");
            resp.setContentType("application/json;charset=UTF-8");
            String jsonStr = "{\"username\":\"admin\",\"password\":\"123\"}";
            resp.getWriter().print(jsonStr);
        } else {
            System.out.println("本次请求不是AJAX请求，转发到index.html...");
            req.getRequestDispatcher("/index.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
