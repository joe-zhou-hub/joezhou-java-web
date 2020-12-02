package com.joezhou.dao;

import com.joezhou.work.dao.LoginDao;
import com.joezhou.work.dao.impl.LoginDaoImpl;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class LoginDaoTest {

    @Test
    public void queryForList(){
        LoginDao loginDao = new LoginDaoImpl();
        System.out.println(loginDao.queryForList());
    }
}
