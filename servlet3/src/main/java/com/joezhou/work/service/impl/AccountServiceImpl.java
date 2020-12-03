package com.joezhou.work.service.impl;

import com.joezhou.work.dao.AccountDao;
import com.joezhou.work.dao.impl.AccountDaoImpl;
import com.joezhou.work.service.AccountService;

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

        Map<String, Object> userFromMysql = accountDao.queryByUsername(username);
        if (userFromMysql != null && !userFromMysql.isEmpty()) {
            return userFromMysql.get("PASSWORD").equals(password);
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
