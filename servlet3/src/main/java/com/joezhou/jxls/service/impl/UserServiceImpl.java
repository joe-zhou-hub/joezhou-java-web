package com.joezhou.jxls.service.impl;

import com.joezhou.jxls.service.UserService;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public class UserServiceImpl implements UserService {

    @Override
    public void listAndPrintExcel(String templatePath, String outputDirectory) throws IOException, InvalidFormatException {
        File directory = new File(outputDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        XLSTransformer transformer = new XLSTransformer();
        Map<String, Object> map = new HashMap<>(2);
        map.put("title", "用户信息表");
        map.put("users", this.list());
        transformer.transformXLS(templatePath, map, outputDirectory + "/user.xls");
    }

    private List<Map<String, Object>> list() {
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
        return users;
    }
}
