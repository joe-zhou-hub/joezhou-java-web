package com.joezhou.work.dao;

import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public interface AccountDao {
    /**
     * 查询全部的账号信息
     *
     * @return 返回全部的账号信息
     */
    List<Map<String, Object>> queryForList();

    /**
     * 通过账号查询信息
     *
     * @param username 账号信息
     * @return 对应账号信息的一条结果
     */
    Map<String, Object> queryByUsername(String username);
}