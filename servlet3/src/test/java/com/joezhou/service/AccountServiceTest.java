package com.joezhou.service;

import com.joezhou.work.service.AccountService;
import com.joezhou.work.service.impl.AccountServiceImpl;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class AccountServiceTest {

    private AccountService accountService = new AccountServiceImpl();

    @Test
    public void login() {
        String username = null;
        String password = null;
        System.out.println(accountService.login(username, password));

        username = "";
        password = "";
        System.out.println(accountService.login(username, password));

        username = "admin";
        password = "";
        System.out.println(accountService.login(username, password));

        username = "zhaosi";
        password = "123";
        System.out.println(accountService.login(username, password));

        username = "123";
        password = "zhaosi";
        System.out.println(accountService.login(username, password));
    }

}
