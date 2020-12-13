package com.joezhou.jxls.service.impl;

import com.joezhou.jxls.service.ExcelService;
import net.sf.jxls.transformer.XLSTransformer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public class ExcelServiceImpl implements ExcelService {

    @Override
    public void listAndPrintExcel(String templatePath, String outputDirectory) {
        File directory = new File(outputDirectory);
        if (!directory.exists()) {
            System.out.println(directory.mkdirs());
        }
        XLSTransformer transformer = new XLSTransformer();
        try {
            transformer.transformXLS(templatePath, getExcelData(), outputDirectory + "/user.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> getExcelData() {
        Map<String, Object> map = new HashMap<>(2);
        List<Map<String, Object>> users = new ArrayList<>();

        Map<String, Object> user;
        int amountOfUsers = 100;
        for (int i = 1; i <= amountOfUsers; i++) {
            user = new HashMap<>(3);
            user.put("id", i);
            user.put("username", "admin-" + i);
            user.put("password", "123" + i);
            users.add(user);
        }

        map.put("title", "用户信息表");
        map.put("users", users);
        return map;
    }
}
