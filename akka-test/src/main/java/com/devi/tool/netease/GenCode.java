package com.devi.tool.netease;

import java.util.List;

/**
 * 代码生成工具类
 * Created by hzchendawei on 2018/3/15.
 */
public class GenCode {

    private static String modelPackagePrefix = "com.netease.kaola.generic.element.model";

    private static String mapperPackagePrefix = "com.netease.kaola.generic.element.dao.mapper.ddb";

    private static String xmlPackagePrefix = "resources/mybatis/ddb";

    private static String modelPath = "com.devi.tool.netease.model";


    public static void main(String[] args) throws Exception {
        List<String> classNames = PackageUtil.getClassName(modelPath, false);

        if (null != classNames && classNames.size() > 0) {
            for (String cn : classNames) {
                System.out.println(cn);
            }
        }


    }

}
