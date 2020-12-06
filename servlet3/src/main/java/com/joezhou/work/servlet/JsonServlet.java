package com.joezhou.work.servlet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.joezhou.work.pojo.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        } else if (Meta.GSON.equals(meta)) {
            gson(req, resp);
        }
    }

    interface Meta {
        String JACKSON = "jackson";
        String GSON = "gson";
    }

    private void jackson(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // new and config objectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss"));

        // writeValueAsString(): map to json-str
        Map<String, Object> map = new HashMap<>(2);
        map.put("map-name", "map-val-1");
        map.put("map-null", null);
        map.put("map-empty", "");
        map.put("map-date", new Date());
        System.out.println(objectMapper.writeValueAsString(map));

        // writeValueAsString(): pojo to json-str
        Account account = new Account(9527, "admin", "123");
        System.out.println(objectMapper.writeValueAsString(account));

        // writeValueAsString(): list<pojo> to json-str
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(9528, "zhaosi", "zhaosi123"));
        accounts.add(new Account(9529, "liuneng", "liuneng123"));
        accounts.add(new Account(9530, "dajiao", "dajiao123"));
        System.out.println(objectMapper.writeValueAsString(accounts));

        // writeValue(): list<map> to json-str and response
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map01 = new HashMap<>(2);
        map01.put("map01-key01", "map01-value01");
        map01.put("map01-key02", "map01-value02");
        Map<String, Object> map02 = new HashMap<>(2);
        map02.put("map02-key01", "map02-value01");
        map02.put("map02-key02", "map02-value02");
        list.add(map01);
        list.add(map02);
        resp.setContentType("text/html;charset=utf-8");
        objectMapper.writeValue(resp.getWriter(), list);
    }

    private void gson(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // toJson(): map to json-str
        Map<String, Object> map = new HashMap<>(2);
        map.put("map-name", "map-val-1");
        map.put("map-null", null);
        map.put("map-empty", "");
        map.put("map-date", new Date());
        System.out.println(new Gson().toJson(map));

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();

        // toJson(): pojo to json-str
        Account account = new Account(9527, "admin", "123");
        System.out.println(gson.toJson(account));

        // toJson(): list<pojo> to json-str
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(9528, "zhaosi", "zhaosi123"));
        accounts.add(new Account(9529, "liuneng", "liuneng123"));
        accounts.add(new Account(9530, "dajiao", "dajiao123"));
        System.out.println(gson.toJson(accounts));

        // toJson(): list<map> to json-str and response
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map01 = new HashMap<>(2);
        map01.put("map01-key01", "map01-value01");
        map01.put("map01-key02", "map01-value02");
        Map<String, Object> map02 = new HashMap<>(2);
        map02.put("map02-key01", "map02-value01");
        map02.put("map02-key02", "map02-value02");
        list.add(map01);
        list.add(map02);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(gson.toJson(list));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
