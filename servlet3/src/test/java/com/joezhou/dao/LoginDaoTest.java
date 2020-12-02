package com.joezhou.dao;

import com.joezhou.work.dao.LoginDao;
import com.joezhou.work.dao.impl.LoginDaoImpl;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class LoginDaoTest {
    private LoginDao loginDao = new LoginDaoImpl();

    @Test
    public void queryForList() {
        System.out.println(loginDao.queryForList());
    }
}
