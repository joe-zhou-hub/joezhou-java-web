package com.joezhou.listener;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/request-attribute-listener")
public class RequestAttributeListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String meta = req.getParameter("meta");

        if (Meta.ADD.equals(meta)) {
            req.setAttribute("request-key", "request-value");
            resp.getWriter().print("请求域属性添加成功！");
        } else if (Meta.REPLACE.equals(meta)) {
            req.setAttribute("request-key", "request-value-a");
            req.setAttribute("request-key", "request-Value-b");
            resp.getWriter().print("请求域属性修改成功！");
        } else if (Meta.REMOVE.equals(meta)) {
            req.setAttribute("request-key", "request-value");
            req.removeAttribute("request-key");
            resp.getWriter().print("请求域属性删除成功！");
        }
    }

    interface Meta {
        String ADD = "add";
        String REPLACE = "replace";
        String REMOVE = "remove";
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}