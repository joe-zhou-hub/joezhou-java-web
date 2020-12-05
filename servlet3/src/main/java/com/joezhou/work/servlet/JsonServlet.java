package com.joezhou.work.servlet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JoeZhou
 */
@WebServlet("/api/json")
public class JsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");

        String meta = req.getParameter("meta");
        if (Meta.JACKSON.equals(meta)) {
            jackson(req, resp);
        }
    }

    interface Meta {
        String JACKSON = "jackson";
    }

    private void jackson(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, Object> map = new HashMap<>(2);
        map.put("map-name", "map-val-1");
        map.put("map-null", null);
        map.put("map-empty", "");
        map.put("map-date", new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss"));

        String jsonStr = objectMapper.writeValueAsString(map);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
