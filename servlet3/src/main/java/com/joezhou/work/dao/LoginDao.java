package com.joezhou.work.dao;

import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public interface LoginDao {
    /**
     * 查询全部的账号信息
     *
     * @return 返回全部的账号信息
     */
    List<Map<String, Object>> queryForList();
}