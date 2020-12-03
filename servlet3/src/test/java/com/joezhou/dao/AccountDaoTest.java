package com.joezhou.dao;

import com.joezhou.work.dao.AccountDao;
import com.joezhou.work.dao.impl.AccountDaoImpl;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class AccountDaoTest {
    private AccountDao accountDao = new AccountDaoImpl();

    @Test
    public void queryForList() {
        System.out.println(accountDao.queryForList());
    }

    @Test
    public void queryByUsername() {
        System.out.println(accountDao.queryByUsername("abc"));
        System.out.println(accountDao.queryByUsername("admin"));
    }
}
