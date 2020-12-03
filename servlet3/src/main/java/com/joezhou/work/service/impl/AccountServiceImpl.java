package com.joezhou.work.service.impl;

import com.joezhou.work.dao.AccountDao;
import com.joezhou.work.dao.impl.AccountDaoImpl;
import com.joezhou.work.service.AccountService;

import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public boolean login(String username, String password) {

        if (isNull(username) || password == null) {
            return false;
        }

        List<Map<String, Object>> accounts = accountDao.queryForList();
        if (accounts == null || accounts.size() <= 0) {
            throw new RuntimeException("查询账号列表失败或数据库中无任何记录...");
        }
        for (Map<String, Object> account : accounts) {
            if (username.equals(account.get("USERNAME")) && password.equals(account.get("PASSWORD"))) {
                return true;
            }
        }
        return false;
    }

    private boolean isNull(String... strings) {
        for (String str : strings) {
            if (str == null || "".equals(str)) {
                return true;
            }
        }
        return false;
    }
}
