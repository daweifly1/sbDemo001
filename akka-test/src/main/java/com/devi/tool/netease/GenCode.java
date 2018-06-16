package com.devi.tool.netease;

import com.devi.tool.netease.freemarker.MapperBean;
import com.devi.tool.util.BeanMapUtil;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 代码生成工具类
 * Created by hzchendawei on 2018/3/15.
 */
public class GenCode {

    private static String modelPackagePrefix = "com.netease.kaola.generic.element.model.";

    private static String mapperPackagePrefix = "com.netease.kaola.generic.element.dao.mapper.ddb";

    private static String xmlPackagePrefix = "resources/mybatis/ddb";

    private static String modelPath = "com.devi.tool.netease.model";


    public static void main(String[] args) throws Exception {
        List<String> classNames = PackageUtil.getClassName(modelPath, false);

        if (null != classNames && classNames.size() > 0) {
            for (String cn : classNames) {
                genDao(cn);
            }
        }





//        MapperBean mapperBean = new MapperBean();
//        mapperBean.setNamespace(mapperPackagePrefix + ".TestModel");
//        mapperBean.setType("ddddddddddddd");
//        List<MapperBean.ModelProperties> list = new ArrayList<>();
//        MapperBean.ModelProperties p = new MapperBean.ModelProperties();
//        p.setColumn("id");
//        list.add(p);
//
//        MapperBean.ModelProperties p2 = new MapperBean.ModelProperties();
//        p2.setColumn("Name");
//        p2.setProperty("name");
//        p2.setJdbcType("VARCHAR");
//        list.add(p2);
//        mapperBean.setPropertiesList(list);
//        parseHtmlFile(GenCode.class.getResource("/").getPath(), "DemoMapper.xml", BeanMapUtil.beanToMap(mapperBean));

    }

    private static void genDao(String cn) throws ClassNotFoundException {
        //根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
        Class clazz = Class.forName(cn);

        //根据Class对象获得属性 私有的也可以获得
        Field[] fields = clazz.getDeclaredFields();

        MapperBean mapperBean = new MapperBean();
        mapperBean.setNamespace(mapperPackagePrefix + "." + clazz.getSimpleName() + "Mapper");
        mapperBean.setType(cn);
        mapperBean.setBeanName(clazz.getSimpleName());
        mapperBean.setTableName("mt" + genColum(clazz.getSimpleName()));
        List<MapperBean.ModelProperties> list = new ArrayList<>();
        for (Field f : fields) {
            //打印每个属性的类型名字
            System.out.println(f.getType().getName() + ":" + f.getName());

            MapperBean.ModelProperties p = new MapperBean.ModelProperties();

            // 获取类上的注解
            CollumComment annotation = f.getAnnotation(CollumComment.class);
            // 输出注解上的属性
            String comment = annotation.value();
            p.setComment(comment);
            p.setLength(annotation.length());
            p.setNullAble(annotation.nullAble());
            p.setColumn(genColum(f.getName()));
            p.setProperty(f.getName());
            if (f.getType().getName().contains("String")) {
                p.setJdbcType("VARCHAR");
            } else if (f.getType().getName().contains("Integer")) {
                p.setJdbcType("INTEGER");
            } else if (f.getType().getName().contains("Date")) {
                p.setJdbcType("TIMESTAMP");
            } else if (f.getType().getName().contains("Long")) {
                p.setJdbcType("BIGINT");
            }
            list.add(p);
        }
        mapperBean.setPropertiesList(list);
        mapperBean.setPackageName(mapperPackagePrefix);

        String temDir = GenCode.class.getResource("/").getPath();
        String out = temDir + "out";
        File outF = new File(out);
        if (!outF.exists()) {
            outF.mkdir();
        }
        parseHtmlFile(temDir + "temp", "DemoMapper.xml", out + "/" + clazz.getSimpleName() + "Mapper.xml", BeanMapUtil.beanToMap(mapperBean));
        parseHtmlFile(temDir + "temp", "DemoMapper.java", out + "/" + clazz.getSimpleName() + "Mapper.java", BeanMapUtil.beanToMap(mapperBean));

        parseHtmlFile(temDir + "temp", "Model.java", out + "/" + clazz.getSimpleName() + ".java", BeanMapUtil.beanToMap(mapperBean));
    }

    private static String genColum(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }


    public static String parseHtmlFile(String temDir, String fileName, String targetFileName, Map<String, Object> paramMap) {
        try {
            // 创建一个合适的Configration对象
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File(temDir));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");
            // 获取或创建一个模版。
            Template template = configuration.getTemplate(fileName);
            Writer writer = new OutputStreamWriter(new FileOutputStream(targetFileName), "UTF-8");
            template.process(paramMap, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }

    private static String readFileContent(String fileName) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = null;
        try {
            File file = new File(fileName);

            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            bf = new BufferedReader(isr);
            String content = "";
            while (content != null) {
                content = bf.readLine();
                if (content == null) {
                    break;
                }
                sb.append(content.trim());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bf) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

}
