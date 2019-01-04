package com.devi.tool.xgit.other;

import com.devi.tool.netease.freemarker.MapperBean;
import com.devi.tool.util.BeanMapUtil;
import com.devi.tool.xgit.GenCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据美化后的sql建表已经生成bean,不考虑部分mysql不支持的sql
 */
public class GenFromOracle {
    private static String mapperPackagePrefix = "xxx";


    public static void main(String[] args) {
        genOracle();
    }

    private static void genOracle() {
        Connection connection = null;
        try {
            String[] tables = {"IUS_PROFILE"};

            /*mysql url的连接字符串*/
            String url = "jdbc:oracle:thin:@scmdb.jt.com:1521:orcl";
            //账号
            String user = "scm";
            //密码
            String password = "scm";
            connection = getOracleConnection(url, user, password);
            if (null != connection) {
                for (String table : tables) {
                    MapperBean mapperBean = genCodeByTable(connection, table, "com.bkwin.jt.dao.entity.consumption", "com.bkwin.jt.service.vo.consumption");
                    if (null != mapperBean) {
                        String temDir = GenCode.class.getResource("/").getPath();


                        String out = temDir + "out";
                        GenCode.mkdirOutPath(temDir, out);
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
                        GenCode.mkDir(doPath, voPath, webPath, servicePath);


//                    GenCode.parseHtmlFile(temDir + "xgTemp", "create_Table.ftl", out + "/dao/" + mapperBean.getTableName() + ".sql", BeanMapUtil.beanToMap(mapperBean));
                        GenCode.parseHtmlFile(temDir + "xgTemp", "DemoMapper.ftl", mapPath + mapperBean.getBeanName() + "Mapper.xml", BeanMapUtil.beanToMap(mapperBean));
                        GenCode.parseHtmlFile(temDir + "xgTemp", "DemoMapper.java", out + "/dao/" + mapperBean.getBeanName() + "Mapper.java", BeanMapUtil.beanToMap(mapperBean));
                        GenCode.parseHtmlFile(temDir + "xgTemp", "Model.java", doPath + mapperBean.getBeanName() + "DO.java", BeanMapUtil.beanToMap(mapperBean));
                        GenCode.parseHtmlFile(temDir + "xgTemp", "ModelVO.java", voPath + mapperBean.getBeanName() + "VO.java", BeanMapUtil.beanToMap(mapperBean));

                        GenCode.parseHtmlFile(temDir + "xgTemp", "ModelServiceImpl.java", servicePath + mapperBean.getBeanName() + "Service.java", BeanMapUtil.beanToMap(mapperBean));
                        GenCode.parseHtmlFile(temDir + "xgTemp", "ModelController.java", webPath + mapperBean.getBeanName() + "Controller.java", BeanMapUtil.beanToMap(mapperBean));
                        GenCode.parseHtmlFile(temDir + "xgTemp", "ModelWeb.js", out + "/web/" + mapperBean.getBeanName() + ".service.ts", BeanMapUtil.beanToMap(mapperBean));

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static MapperBean genCodeByTable(Connection connection, String table, String doPath, String voPath) throws Exception {
        MapperBean mapperBean = null;
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user_tab_comments where table_name='" + table + "'");
        String beanName = getBeanNameFromTable(table, true);
        if (rs != null && rs.next()) {
            String comment = rs.getString("COMMENTS");
            mapperBean = new MapperBean();

            mapperBean.setNamespace("com.bkwin.jt.dao.mapper." + mapperPackagePrefix + "." + beanName + "Mapper");
            mapperBean.setTableComment(null == comment ? "//待完善" : comment);
        }
        if (null == mapperBean) {
            System.out.println("error");
            return mapperBean;
        }

        mapperBean.setType(doPath + "." + beanName + "DO");
        mapperBean.setVoType(voPath + "." + beanName + "VO");
        mapperBean.setBeanName(beanName);
        mapperBean.setFistLowerBeanName(mapperBean.getBeanName().substring(0, 1).toLowerCase() + mapperBean.getBeanName().substring(1));

        mapperBean.setTableTsName(table);
        mapperBean.setTableName(table);
        List<MapperBean.ModelProperties> list = new ArrayList<>();

        rs = stmt.executeQuery("select t.DATA_SCALE, t.DATA_PRECISION, t.COLUMN_NAME \"Field\",t.DATA_LENGTH,t.DATA_TYPE \"Type\",c.COMMENTS \"Comment\" from user_tab_columns t join USER_COL_COMMENTS c on c.COLUMN_NAME=t.COLUMN_NAME and c.Table_Name=t.Table_Name where t.Table_Name='" + table + "'");
        while (rs.next()) {
            MapperBean.ModelProperties p = new MapperBean.ModelProperties();
            String comment = rs.getString("Comment");
            p.setComment(null == comment ? "" : comment);

            p.setRequired(false);
            p.setNullAble(true);
            p.setColumn(rs.getString("Field"));
            p.setProperty(getBeanNameFromTable(rs.getString("Field"), false));

            p.setLength(rs.getInt("DATA_LENGTH"));
            p.setJdbcType(getJDBCType(rs.getString("Type")));
            p.setJavaType(sqlType2JavaType(rs.getString("Type")));
            int data_scale = rs.getInt("DATA_SCALE");
            if (p.getJdbcType().equals("Integer") && p.getLength() > 10 && data_scale > 0) {
                p.setJavaType("BigDecimal");
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


    private static Connection getOracleConnection(String url, String user, String password) {
        Connection connection = null;
        PreparedStatement UserQuery;
        //mysql jdbc的java包驱动字符串
        String driverClassName = "oracle.jdbc.OracleDriver";
        try {//驱动注册
            Class.forName(driverClassName);
            if (connection == null || connection.isClosed()) {
                //获得链接
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Oh,not");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Oh,not");
        }
        return connection;
    }


    private static String getFirstLowerBeanNameFromTable(String table) {
        String s = getBeanNameFromTable(table, false);
        return s;

    }

    private static String getBeanNameFromTable(String table, boolean beanName) {
        String str = table.toUpperCase();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        if (beanName) {
            sb.append(str.charAt(i));
        } else {
            sb.append((str.charAt(i) + "").toLowerCase());
        }
        i++;
        boolean nextUpper = false;
        while (i < str.length()) {
            Character chr = str.charAt(i);
            if (null == chr) {
                i++;
                continue;
            }
            if (chr.toString().equals("_")) {
                nextUpper = true;
            } else {
                if (nextUpper) {
                    sb.append(chr);
                } else {
                    sb.append(chr.toString().toLowerCase());
                }
                nextUpper = false;
            }
            i++;
        }
        return sb.toString();
    }

    /*
     * mysql的字段类型转化为java的类型*/
    private static String sqlType2JavaType(String sqlType) {

        if (sqlType.toLowerCase().contains("bit")) {
            return "boolean";
        } else if (sqlType.toLowerCase().contains("tinyint")) {
            return "byte";
        } else if (sqlType.toLowerCase().contains("smallint")) {
            return "short";
        } else if (sqlType.toLowerCase().contains("int")) {
            return "int";
        } else if (sqlType.toLowerCase().contains("bigint")) {
            return "long";
        } else if (sqlType.toLowerCase().contains("float")) {
            return "float";
        } else if (sqlType.toLowerCase().contains("decimal") || sqlType.toLowerCase().contains("numeric")
                || sqlType.toLowerCase().contains("real") || sqlType.toLowerCase().contains("money")
                || sqlType.toLowerCase().contains("smallmoney")) {
            return "double";
        } else if (sqlType.toLowerCase().contains("number")) {
            return "Integer";
        } else if (sqlType.toLowerCase().contains("varchar") || sqlType.toLowerCase().contains("char")
                || sqlType.toLowerCase().contains("nvarchar") || sqlType.toLowerCase().contains("nchar")
                || sqlType.toLowerCase().contains("text")) {
            return "String";
        } else if (sqlType.toLowerCase().contains("datetime") || sqlType.toLowerCase().contains("date")) {
            return "Date";
        } else if (sqlType.toLowerCase().contains("image")) {
            return "Blod";
        } else if (sqlType.toLowerCase().contains("timestamp")) {
            return "Timestamp";
        }

        return null;
    }

    private static String getJDBCType(String sqlType) {
        if (sqlType.toLowerCase().contains("bit")) {
            return "BIT";
        } else if (sqlType.toLowerCase().contains("tinyint")) {
            return "TINYINT";
        } else if (sqlType.toLowerCase().contains("smallint")) {
            return "SMALLINT";
        } else if (sqlType.toLowerCase().contains("int")) {
            return "INTEGER";
        } else if (sqlType.toLowerCase().contains("bigint")) {
            return "BIGINT";
        } else if (sqlType.toLowerCase().contains("float")) {
            return "FLOAT";
        } else if (sqlType.toLowerCase().contains("decimal") || sqlType.toLowerCase().contains("numeric")
                || sqlType.toLowerCase().contains("real") || sqlType.toLowerCase().contains("money")
                || sqlType.toLowerCase().contains("smallmoney")) {
            return "DECIMAL";
        } else if (sqlType.toLowerCase().contains("number")) {
            return "DECIMAL";
        } else if (sqlType.toLowerCase().contains("varchar") || sqlType.toLowerCase().contains("char")
                || sqlType.toLowerCase().contains("nvarchar") || sqlType.toLowerCase().contains("nchar")
                || sqlType.toLowerCase().contains("text")) {
            return "VARCHAR";
        } else if (sqlType.toLowerCase().contains("datetime") || sqlType.toLowerCase().contains("date")) {
            return "TIMESTAMP";
        } else if (sqlType.toLowerCase().contains("image")) {
            return "BLOD";
        } else if (sqlType.toLowerCase().contains("timestamp")) {
            return "TIMESTAMP";
        }
        System.out.println("cannot find ===========" + sqlType);
        return null;
    }

    public static String parse(String all) {
        all = all.toUpperCase();
        String comment = null;
        int index = all.indexOf("COMMENT='");
        if (index < 0) {
            return "";
        }
        comment = all.substring(index + 9);
        comment = comment.substring(0, comment.length() - 1);
        return comment;
    }
}
