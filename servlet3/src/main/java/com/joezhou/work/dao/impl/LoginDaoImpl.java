package com.joezhou.work.dao.impl;

import com.joezhou.jdbc.JdbcTemplate;
import com.joezhou.work.dao.LoginDao;

import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public class LoginDaoImpl implements LoginDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public List<Map<String, Object>> queryForList() {
        String sql = "SELECT ID, USERNAME, PASSWORD FROM ACCOUNT";
        return jdbcTemplate.queryForList(sql);
    }
}