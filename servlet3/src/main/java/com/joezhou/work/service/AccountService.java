package com.joezhou.work.service;

/**
 * @author JoeZhou
 */
public interface AccountService {
    /**
     * 登录业务，检查登录是否成功
     *
     * @param username 前端传递过来的账号
     * @param password 前端传递过来的密码
     * @return 如果登录成功返回true，否则返回false
     */
    boolean login(String username, String password);
}
