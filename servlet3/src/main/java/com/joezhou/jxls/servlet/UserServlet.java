package com.joezhou.jxls.servlet;

import com.joezhou.jxls.service.UserService;
import com.joezhou.jxls.service.impl.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JoeZhou
 */
@WebServlet("/api/user")
public class UserServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String templatePath = req.getServletContext().getRealPath("/template/user-template.xls");
        String outputDirectory = req.getServletContext().getRealPath("/excel");
        UserService userService = new UserServiceImpl();
        userService.listAndPrintExcel(templatePath, outputDirectory);

        // 直接重定向访问要打印的文件可以下载文件，但这种方式无法识别中文，如果是中文，使用IO流下载
        resp.sendRedirect(req.getContextPath() + "/excel/user.xls");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}