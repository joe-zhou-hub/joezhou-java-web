package com.joezhou.work.dao.impl;

import com.joezhou.jdbc.JdbcTemplate;
import com.joezhou.work.dao.AccountDao;

import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public List<Map<String, Object>> queryForList() {
        return jdbcTemplate.queryForList("SELECT ID, USERNAME, PASSWORD FROM ACCOUNT");
    }
}