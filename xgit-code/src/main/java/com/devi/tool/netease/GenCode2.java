package com.devi.tool.netease;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
//                genCopy(cn, "babyGoodsInfoVO", "g");

                genMock(cn, "model");
            }
        }

//        Map a=getMap();
//        System.out.println(a);
    }




    private static void genCopy(String cn, String o, String t) throws ClassNotFoundException {
        //根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
        Class clazz = Class.forName(cn);

        //根据Class对象获得属性 私有的也可以获得
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            //打印每个属性的类型名字
            System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + t + ".get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "());");
        }

    }


    private static void genMock(String cn, String o) throws ClassNotFoundException {
        //根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
        Class clazz = Class.forName(cn);

        //根据Class对象获得属性 私有的也可以获得
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.getType().getName().contains("String")) {
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + getRandomString(5) + ");");
            } else if (f.getType().getName().contains("Integer")) {
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + getRandomInt(4) + ");");
            } else if (f.getType().getName().contains("BigDecimal")) {
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + "new BigDecimal(" + getRandomInt(4) + ")" + ");");
            } else if (f.getType().getName().contains("Date")) {
                System.out.println("Date current=new Date();");
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(current);");
            } else if (f.getType().getName().contains("Timestamp")) {
                System.out.println("Timestamp t=new Timestamp(System.currentTimeMillis());");

                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(t);");
            } else if (f.getType().getName().contains("Long")) {
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + getRandomLong(4) + ");");
            } else {
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(???);");
            }

            //打印每个属性的类型名字

        }


    }

    public static String getRandomString(int length) {
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        //长度为几就循环几次
        for (int i = 0; i < length; ++i) {
            //产生0-61的数字
            int number = random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return "\"" + sb.toString() + "\"";
    }

    public static int getRandomInt(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        return random.nextInt(length);
    }

    public static long getRandomLong(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        return random.nextInt(length) + 1000L;
    }

    public static Map getMap() {
        Map map=null;
        try {
            map=new HashMap();
            map.put("s","s");
            return map;
        }finally {
            map=new HashMap();
            map.put("s","s2");
        }

    }
}
