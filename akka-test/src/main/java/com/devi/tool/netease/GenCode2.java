package com.devi.tool.netease;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 代码生成工具类
 * Created by hzchendawei on 2018/3/15.
 */
public class GenCode2 {


    private static String modelPath = "com.devi.tool.netease.model2";


    public static void main(String[] args) throws Exception {
        List<String> classNames = PackageUtil.getClassName(modelPath, false);

        if (null != classNames && classNames.size() > 0) {
            for (String cn : classNames) {
                genDao(cn, "vo", "data");
            }
        }

    }

    private static void genDao(String cn, String o, String t) throws ClassNotFoundException {
        //根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
        Class clazz = Class.forName(cn);

        //根据Class对象获得属性 私有的也可以获得
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            //打印每个属性的类型名字
            System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + t + ".get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "());");
        }

    }


}
