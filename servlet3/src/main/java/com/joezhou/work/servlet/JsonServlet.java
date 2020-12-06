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

    private Map<String, Object> getMap(int num) {
        Map<String, Object> map01 = new HashMap<>(2);
        map01.put("map-key-1", "map-val-1");
        map01.put("map-null-1", null);
        map01.put("map-empty-1", "");
        map01.put("map-date-1", new Date());
        map01.put("map-gender-1", "1");

        Map<String, Object> map02 = new HashMap<>(2);
        map02.put("map-key-2", "map-val-2");
        map02.put("map-null-2", null);
        map02.put("map-empty-2", "");
        map02.put("map-date-2", new Date());
        map02.put("map-gender-2", "1");
        return num == 1 ? map01 : map02;
    }

    private Account getAccount(int num) {
        Account account01 = new Account(9527, "user-1", "pass-1");
        Account account02 = new Account(9528, "user-2", "pass-2");
        return num == 1 ? account01 : account02;
    }

    private void jackson(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // new objectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // writeValueAsString(): map to json-str
        System.out.println(objectMapper.writeValueAsString(this.getMap(1)));

        // writeValueAsString(): pojo to json-str
        System.out.println(objectMapper.writeValueAsString(this.getAccount(1)));

        // writeValueAsString(): list<pojo> to json-str
        List<Account> accounts = new ArrayList<>();
        accounts.add(this.getAccount(1));
        accounts.add(this.getAccount(2));
        System.out.println(objectMapper.writeValueAsString(accounts));

        // new and config objectMapper
        objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss"));

        // writeValue(): list<map> to json-str and response
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(this.getMap(1));
        list.add(this.getMap(2));
        resp.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(resp.getWriter(), list);
    }

    private void gson(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Gson gson = new Gson();

        // toJson(): map to json-str
        System.out.println(gson.toJson(this.getMap(1)));

        // toJson(): pojo to json-str
        System.out.println(gson.toJson(this.getAccount(1)));

        // toJson(): list<pojo> to json-str
        List<Account> accounts = new ArrayList<>();
        accounts.add(this.getAccount(1));
        accounts.add(this.getAccount(2));
        System.out.println(gson.toJson(accounts));

        // new gson by GsonBuilder
        gson = new GsonBuilder()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd")
                .create();

        // toJson(): list<map> to json-str and response
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(this.getMap(1));
        list.add(this.getMap(2));
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(gson.toJson(list));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
