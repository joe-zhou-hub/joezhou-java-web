package com.joezhou.jxls.service;

/**
 * @author JoeZhou
 */
public interface ExcelService {

    /**
     * 获取所有的用户信息并打印报表
     *
     * @param templatePath    模板真实物理路径
     * @param outputDirectory Excel文件输出位置
     */
    void listAndPrintExcel(String templatePath, String outputDirectory);
}
