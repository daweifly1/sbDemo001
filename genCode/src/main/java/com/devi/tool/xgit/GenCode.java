package com.devi.tool.xgit;

import com.devi.tool.netease.PackageUtil;
import com.devi.tool.netease.freemarker.MapperBean;
import com.devi.tool.util.BeanMapUtil;
import com.devi.tool.xgit.annotation.TableComment;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import io.swagger.annotations.ApiModelProperty;

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

    private static String mapperPackagePrefix = "consumption";

    private static String modelPath = "com.devi.tool.xgit.model";


    public static void main(String[] args) throws Exception {
        List<String> classNames = PackageUtil.getClassName(modelPath, false);

        if (null != classNames && classNames.size() > 0) {
            for (String cn : classNames) {
                genDao(cn, "com.bkwin.jt.dao.entity.consumption", "com.bkwin.jt.service.vo.consumption");
            }
        }
    }

    private static void genDao(String cn, String dPath, String vPath) throws ClassNotFoundException {
        String temDir = GenCode.class.getResource("/").getPath();
        String out = temDir + "out";
        mkdirOutPath(temDir, out);
        String mapPath = out + "/do/";
//         mapPath = "F:\\jt\\jx_copper_storage\\src\\main\\resources\\mybatis\\mapper\\";
        String servicePath = out + "/service/";
//        servicePath = "F:\\jt\\jx_copper_storage\\src\\main\\java\\com\\bkwin\\jt\\service\\"+mapperPackagePrefix+"\\";

        String doPath = out + "/do/";
//        doPath = "F:\\jt\\jx_copper_storage\\src\\main\\java\\com\\bkwin\\jt\\dao\\entity\\"+mapperPackagePrefix+"\\";

        String voPath = out + "/do/";
//        voPath = "F:\\jt\\jx_copper_storage\\src\\main\\java\\com\\bkwin\\jt\\service\\vo\\"+mapperPackagePrefix+"\\";

        String webPath = out + "/web/";
//        webPath = "F:\\jt\\jx_copper_storage\\src\\main\\java\\com\\bkwin\\jt\\web\\"+mapperPackagePrefix+"\\";
        mkDir(doPath, voPath, webPath, servicePath);

        MapperBean mapperBean = doGenCode(cn, dPath, vPath);
        if (null == mapperBean) {
            System.out.println("gen fail " + cn);
            return;
        }
        //根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
        Class clazz = Class.forName(cn);


        parseHtmlFile(temDir + "xgTemp", "create_Table.ftl", out + "/dao/" + mapperBean.getTableName() + ".sql", BeanMapUtil.beanToMap(mapperBean));
        parseHtmlFile(temDir + "xgTemp", "DemoMapper.ftl", mapPath + clazz.getSimpleName() + "Mapper.xml", BeanMapUtil.beanToMap(mapperBean));
        parseHtmlFile(temDir + "xgTemp", "DemoMapper.java", out + "/dao/" + clazz.getSimpleName() + "Mapper.java", BeanMapUtil.beanToMap(mapperBean));
        parseHtmlFile(temDir + "xgTemp", "Model.java", doPath + clazz.getSimpleName() + "DO.java", BeanMapUtil.beanToMap(mapperBean));
        parseHtmlFile(temDir + "xgTemp", "ModelVO.java", voPath + clazz.getSimpleName() + "VO.java", BeanMapUtil.beanToMap(mapperBean));

        parseHtmlFile(temDir + "xgTemp", "ModelServiceImpl.java", servicePath + clazz.getSimpleName() + "Service.java", BeanMapUtil.beanToMap(mapperBean));

        parseHtmlFile(temDir + "xgTemp", "ModelController.java", webPath + clazz.getSimpleName() + "Controller.java", BeanMapUtil.beanToMap(mapperBean));

        parseHtmlFile(temDir + "xgTemp", "ModelWeb.js", out + "/web/" + genTsName(clazz.getSimpleName()) + ".service.ts", BeanMapUtil.beanToMap(mapperBean));

    }

    private static void mkDir(String... path) {
        for (String d : path) {
            File f = new File(d);
            if (!f.exists()) {
                f.mkdir();
            }
        }
    }

    private static void mkdirOutPath(String temDir, String outParent) {
        File outF = new File(outParent);
        if (!outF.exists()) {
            outF.mkdir();
        }

        String out = null;
        out = temDir + "out/dao";
        outF = new File(out);
        if (!outF.exists()) {
            outF.mkdir();
        }
        out = temDir + "out/service";
        outF = new File(out);
        if (!outF.exists()) {
            outF.mkdir();
        }
        out = temDir + "out/web";
        outF = new File(out);
        if (!outF.exists()) {
            outF.mkdir();
        }
    }

    private static MapperBean doGenCode(String cn, String doPath, String voPath) throws ClassNotFoundException {
        //根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
        Class clazz = Class.forName(cn);

        //根据Class对象获得属性 私有的也可以获得
        Field[] fields = clazz.getDeclaredFields();

        MapperBean mapperBean = new MapperBean();
        mapperBean.setNamespace("com.bkwin.jt.dao.mapper." + mapperPackagePrefix + "." + clazz.getSimpleName() + "Mapper");

        // 获取类上的注解
        TableComment tableAnno = (TableComment) clazz.getAnnotation(TableComment.class);
        if (null == tableAnno) {
            return null;
        }
        mapperBean.setTableComment(tableAnno.value());
        mapperBean.setType(doPath + "." + clazz.getSimpleName() + "DO");
        mapperBean.setVoType(voPath + "." + clazz.getSimpleName() + "VO");
        mapperBean.setBeanName(clazz.getSimpleName());
        mapperBean.setFistLowerBeanName(mapperBean.getBeanName().substring(0, 1).toLowerCase() + mapperBean.getBeanName().substring(1));

        mapperBean.setTableTsName(genTsName(mapperBean.getBeanName()));

        mapperBean.setTableName("T" + genColum(clazz.getSimpleName()));
        List<MapperBean.ModelProperties> list = new ArrayList<>();
        for (Field f : fields) {
            //打印每个属性的类型名字
            System.out.println(f.getType().getName() + ":" + f.getName());

            MapperBean.ModelProperties p = new MapperBean.ModelProperties();

            // 获取类上的注解
            ApiModelProperty annotation = f.getAnnotation(ApiModelProperty.class);
            if (annotation == null) {
                continue;
            }
            // 输出注解上的属性
            String comment = annotation.value();
            p.setComment(comment);

            p.setRequired(annotation.required());
            p.setNullAble(!annotation.required());
            p.setColumn(genColum(f.getName()));
            p.setProperty(f.getName());
            if (f.getType().getName().contains("String")) {
                p.setLength(255);
                p.setJdbcType("VARCHAR");
                p.setJavaType("String");
            } else if (f.getType().getName().contains("Integer") || f.getType().getName().contains("int")) {
                p.setJdbcType("DECIMAL");
                p.setJavaType("Integer");
                p.setLength(2);
            } else if (f.getType().getName().contains("Short") || f.getType().getName().contains("short")) {
                p.setJdbcType("DECIMAL");
                p.setJavaType("Short");
                p.setLength(6);
            } else if (f.getType().getName().contains("Date")) {
                p.setJdbcType("TIMESTAMP");
                p.setJavaType("Date");
                p.setLength(6);
            } else if (f.getType().getName().contains("Timestamp")) {
                p.setJdbcType("TIMESTAMP");
                p.setJavaType("Timestamp");
                p.setLength(6);
            } else if (f.getType().getName().contains("Long")) {
                p.setJdbcType("DECIMAL");
                p.setJavaType("Long");
                p.setLength(20);
            } else if (f.getType().getName().contains("BigDecimal")) {
                p.setJdbcType("DECIMAL");
                p.setJavaType("BigDecimal");
                p.setLength(50);
            } else {
                p.setJavaType(f.getType().getName());
            }

            list.add(p);
        }
        mapperBean.setPropertiesList(list);
        mapperBean.setPackageName(mapperPackagePrefix);

        mapperBean.setMapperPackageName("com.bkwin.jt.dao.mapper." + mapperPackagePrefix);
        mapperBean.setDoPackageName("com.bkwin.jt.dao.entity." + mapperPackagePrefix);

        mapperBean.setVoPackageName("com.bkwin.jt.service.vo." + mapperPackagePrefix);

        mapperBean.setServicePackageName("com.bkwin.jt.service." + mapperPackagePrefix);

        mapperBean.setCtrPackageName("com.bkwin.jt.web." + mapperPackagePrefix);
        return mapperBean;
    }

    private static String genTsName(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < str.length()) {
            char chr = str.charAt(i);
            if (i > 0 && Character.isUpperCase(chr)) {
                sb.append("-").append(chr);
            } else {
                sb.append(chr);
            }
            i++;
        }
        return sb.toString().toLowerCase();
    }

    private static String genColum(String str) {
        return str.replaceAll("[A-Z]", "_$0").toUpperCase();
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
