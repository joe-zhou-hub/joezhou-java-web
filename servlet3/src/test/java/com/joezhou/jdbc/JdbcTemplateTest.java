package com.joezhou.jdbc;

import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public class JdbcTemplateTest {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Test
    public void queryForList() {
        String sql = "SELECT ID, USERNAME, PASSWORD FROM ACCOUNT";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }
}
