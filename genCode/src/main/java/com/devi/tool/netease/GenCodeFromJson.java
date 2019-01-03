package com.devi.tool.netease;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

/**
 * 代码生成工具类
 * Created by hzchendawei on 2018/3/15.
 */
public class GenCodeFromJson {

    public static void main(String[] args) throws Exception {

        String json = "{\n" +
                "\t\"activityName\": \"111\",\n" +
                "\t\"baseRedenvelopeVO\": {\n" +
                "\t\t\"couponAmount\": 10000.00,\n" +
                "\t\t\"couponCloseTime\": 1545753540000,\n" +
                "\t\t\"couponName\": \"组团瓜分红包test1\",\n" +
                "\t\t\"couponOpenTime\": 1529942400000,\n" +
                "\t\t\"couponSchemaId\": 17041,\n" +
                "\t\t\"dispatcherOver\": false,\n" +
                "\t\t\"expireDays\": 1,\n" +
                "\t\t\"redEnvolpeFrontId\": \"4eeb83ccb8d84967ac1b04de4cd08b94\"\n" +
                "\t},\n" +
                "\t\"curTime\": 1530065701079,\n" +
                "\t\"dbCreateAuthor\": \"SystemRequest\",\n" +
                "\t\"dbCreateTime\": 1530023405398,\n" +
                "\t\"dbUpdateAuthor\": \"SystemRequest\",\n" +
                "\t\"dbUpdateTime\": 1530023405398,\n" +
                "\t\"endTime\": 1531497584000,\n" +
                "\t\"id\": 8,\n" +
                "\t\"interest\": \"1111\",\n" +
                "\t\"legoPageLink\": \"111\",\n" +
                "\t\"memberActivityTime\": 11,\n" +
                "\t\"memberEveryDay\": 11,\n" +
                "\t\"newAccountLimit\": 11,\n" +
                "\t\"newRedenvelopeVO\": {\n" +
                "\t\t\"couponActivtyTime\": 1529942400000,\n" +
                "\t\t\"couponAmount\": 10000.00,\n" +
                "\t\t\"couponCloseTime\": 1545753540000,\n" +
                "\t\t\"couponExpireTime\": 1545753540000,\n" +
                "\t\t\"couponName\": \"组团瓜分红包test3\",\n" +
                "\t\t\"couponOpenTime\": 1529942400000,\n" +
                "\t\t\"couponSchemaId\": 17042,\n" +
                "\t\t\"dispatcherOver\": false,\n" +
                "\t\t\"redEnvolpeFrontId\": \"dbb5b95d27b045979a1142a6b88ab73d\"\n" +
                "\t},\n" +
                "\t\"oldAccountLimit\": 11,\n" +
                "\t\"pageJumpLink\": \"http://mp-kl.kaola.com/redEnvelope.html\",\n" +
                "\t\"redenvelopeVOList\": [{\n" +
                "\t\t\"couponAmount\": 10000.00,\n" +
                "\t\t\"couponCloseTime\": 1545753540000,\n" +
                "\t\t\"couponName\": \"组团瓜分红包test1\",\n" +
                "\t\t\"couponOpenTime\": 1529942400000,\n" +
                "\t\t\"couponSchemaId\": 17041,\n" +
                "\t\t\"dispatcherOver\": false,\n" +
                "\t\t\"expireDays\": 1,\n" +
                "\t\t\"redEnvolpeFrontId\": \"4eeb83ccb8d84967ac1b04de4cd08b94\"\n" +
                "\t}, {\n" +
                "\t\t\"couponAmount\": 10000.00,\n" +
                "\t\t\"couponCloseTime\": 1545753540000,\n" +
                "\t\t\"couponName\": \"组团瓜分红包test1\",\n" +
                "\t\t\"couponOpenTime\": 1529942400000,\n" +
                "\t\t\"couponSchemaId\": 17041,\n" +
                "\t\t\"dispatcherOver\": false,\n" +
                "\t\t\"expireDays\": 1,\n" +
                "\t\t\"redEnvolpeFrontId\": \"4eeb83ccb8d84967ac1b04de4cd08b94\"\n" +
                "\t}, {\n" +
                "\t\t\"couponAmount\": 10000.00,\n" +
                "\t\t\"couponCloseTime\": 1545753540000,\n" +
                "\t\t\"couponName\": \"组团瓜分红包test1\",\n" +
                "\t\t\"couponOpenTime\": 1529942400000,\n" +
                "\t\t\"couponSchemaId\": 17041,\n" +
                "\t\t\"dispatcherOver\": false,\n" +
                "\t\t\"expireDays\": 1,\n" +
                "\t\t\"redEnvolpeFrontId\": \"4eeb83ccb8d84967ac1b04de4cd08b94\"\n" +
                "\t}, {\n" +
                "\t\t\"couponAmount\": 10000.00,\n" +
                "\t\t\"couponCloseTime\": 1545753540000,\n" +
                "\t\t\"couponName\": \"组团瓜分红包test1\",\n" +
                "\t\t\"couponOpenTime\": 1529942400000,\n" +
                "\t\t\"couponSchemaId\": 17041,\n" +
                "\t\t\"dispatcherOver\": false,\n" +
                "\t\t\"expireDays\": 1,\n" +
                "\t\t\"redEnvolpeFrontId\": \"4eeb83ccb8d84967ac1b04de4cd08b94\"\n" +
                "\t}, {\n" +
                "\t\t\"couponAmount\": 10000.00,\n" +
                "\t\t\"couponCloseTime\": 1545753540000,\n" +
                "\t\t\"couponName\": \"组团瓜分红包test1\",\n" +
                "\t\t\"couponOpenTime\": 1529942400000,\n" +
                "\t\t\"couponSchemaId\": 17041,\n" +
                "\t\t\"dispatcherOver\": false,\n" +
                "\t\t\"expireDays\": 1,\n" +
                "\t\t\"redEnvolpeFrontId\": \"4eeb83ccb8d84967ac1b04de4cd08b94\"\n" +
                "\t}],\n" +
                "\t\"startTime\": 1530028800000,\n" +
                "\t\"teamLeaderActivityTime\": 11,\n" +
                "\t\"teamLeaderEveryDay\": 11,\n" +
                "\t\"timeType\": 1\n" +
                "}";
//        RedenvelopeScheduleVO vo = FastJsonUtil.parse(json, RedenvelopeScheduleVO.class);
//
//        genMockFromJson("com.devi.tool.netease.model2.RedenvelopeScheduleVO", "model", vo, "");

    }

    private static void genMockFromJson(String cn, String o, Object m, String fix) throws ClassNotFoundException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        //根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
        Class clazz = Class.forName(cn);


        //根据Class对象获得属性 私有的也可以获得
        Field[] fields = clazz.getDeclaredFields();
        int index = 1;
        for (Field f : fields) {
            if (Modifier.isStatic(f.getModifiers())) {
                continue;
            }
            PropertyDescriptor proDescriptor = new PropertyDescriptor(f.getName(), clazz);
            Method methodGetUserName = proDescriptor.getReadMethod();
            Object objUserName = methodGetUserName.invoke(m);

            if (f.getType().getName().contains("String")) {
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + getRandomString(5, objUserName) + ");");
            } else if (f.getType().getName().contains("Integer")) {
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + getRandomInt(4, objUserName) + ");");
            } else if (f.getType().getName().contains("BigDecimal")) {
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + "new BigDecimal(" + objUserName + ")" + ");");
            } else if (f.getType().getName().contains("Date")) {
                System.out.println("Date current=new Date(" + objUserName + ");");
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(current);");
            } else if (f.getType().getName().contains("Timestamp")) {
                if (objUserName == null) {
                    System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(null);");
                } else {
                    String tName = "t" + fix + index;

                    System.out.println("Timestamp " + tName + "=new Timestamp(" + ((Timestamp) objUserName).getTime() + "L);");

                    System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + tName + ");");
                }
            } else if (f.getType().getName().contains("Long")) {
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + getRandomLong(4, objUserName) + "L);");
            } else if (f.getType().getName().contains("Boolean") || f.getType().getName().contains("boolean")) {
                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + objUserName + ");");
            } else if (f.getType().getName().contains("List")) {
                List list = (List) objUserName;
                if (null == list || 0 == list.size()) {
                    System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(null);");
                } else {
                    String listName = "list" + index;

                    int ind = 1;
                    for (Object o1 : list) {
                        if (ind == 1) {
                            System.out.println("List " + listName + "=new ArrayList<" + o1.getClass().getSimpleName() + ">();");
                        }
                        String objName = o1.getClass().getSimpleName().substring(0, 1).toLowerCase() + o1.getClass().getSimpleName().substring(1) + ind;
                        System.out.println(o1.getClass().getSimpleName() + "  " + objName + "=new " + o1.getClass().getSimpleName() + "();");
                        genMockFromJson(o1.getClass().getName(), objName, o1, objName);
                        System.out.println(listName + ".add(" + objName + ");");
                        ind++;
                    }
                    System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + listName + ");");
                }
            } else {
                String objName = objUserName.getClass().getSimpleName().substring(0, 1).toLowerCase() + objUserName.getClass().getSimpleName().substring(1) + index;
                System.out.println(objUserName.getClass().getSimpleName() + " " + objName + "=new " + objUserName.getClass().getSimpleName() + "();");
                genMockFromJson(objUserName.getClass().getName(), objName, objUserName, objName);

                System.out.println(o + ".set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + "(" + objName + ");");
            }
            //打印每个属性的类型名字

            index++;
        }


    }

    public static String getRandomString(int length, Object t) {
        if (null != t) {
            return "\"" + t.toString() + "\"";
        }
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

    public static int getRandomInt(int length, Object t) {
        if (null != t) {
            return (int) t;
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        return random.nextInt(length);
    }

    public static long getRandomLong(int length, Object t) {
        if (null != t) {
            return (long) t;
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        return random.nextInt(length) + 1000L;
    }
}
