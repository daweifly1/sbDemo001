package com.devi;

import java.io.*;

/**
 * Created by hzchendawei on 2018/4/12.
 */
public class SQLTextTest {

    public static void main(String[] args) {
        //drop
        drop();

        createWithoutSome();

        insert();

        alter();

    }

    private static void alter() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\xcit\\Desktop\\SCM-Dev.sql"), "utf-8"));
//            #
//            这里主要是涉及中文
            //            这里主要是涉及中文
            //BufferedReader in = new BufferedReader(new FileReader("d:\\1.txt")));
            //写入相应的文件
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\xcit\\Desktop\\alter.sql"), "utf-8"));
            //BufferedWriter out = new BufferedWriter(new FileWriter("d:\\2.txt"))；
            //读取数据
            //循环取出数据
            String str = null;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
                if (str.toLowerCase().trim().startsWith("insert") && str.toLowerCase().contains("into")) {
                } else if (str.toUpperCase().trim().startsWith("DROP")) {
                } else if (str.toUpperCase().trim().startsWith("ALTER TABLE")) {
                    out.write(str);
                    out.newLine();
                } else {//写入相关文件
                }
            }

            //清楚缓存
            out.flush();
            //关闭流
            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insert() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\xcit\\Desktop\\SCM-Dev.sql"), "utf-8"));
//            #
//            这里主要是涉及中文
            //            这里主要是涉及中文
            //BufferedReader in = new BufferedReader(new FileReader("d:\\1.txt")));
            //写入相应的文件
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\xcit\\Desktop\\insert.sql"), "utf-8"));
            //BufferedWriter out = new BufferedWriter(new FileWriter("d:\\2.txt"))；
            //读取数据
            //循环取出数据
            String str = null;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
                if (str.toLowerCase().trim().startsWith("insert") && str.toLowerCase().contains("into")) {
                    out.write(str);
                    out.newLine();
                } else if (str.toUpperCase().trim().startsWith("DROP")) {
                } else if (str.toUpperCase().trim().startsWith("ALTER TABLE")) {
                } else {//写入相关文件
                }
            }

            //清楚缓存
            out.flush();
            //关闭流
            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createWithoutSome() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\xcit\\Desktop\\SCM-Dev.sql"), "utf-8"));
//            #
//            这里主要是涉及中文
            //            这里主要是涉及中文
            //BufferedReader in = new BufferedReader(new FileReader("d:\\1.txt")));
            //写入相应的文件
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\xcit\\Desktop\\create.sql"), "utf-8"));
            //BufferedWriter out = new BufferedWriter(new FileWriter("d:\\2.txt"))；
            //读取数据
            //循环取出数据
            String str = null;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
                if (str.toLowerCase().trim().startsWith("insert") && str.toLowerCase().contains("into")) {

                } else if (str.toUpperCase().trim().startsWith("DROP")) {
                } else if (str.toUpperCase().trim().startsWith("ALTER TABLE")) {
                } else {//写入相关文件
                    out.write(str);
                    out.newLine();
                }
            }

            //清楚缓存
            out.flush();
            //关闭流
            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void drop() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\xcit\\Desktop\\SCM-Dev.sql"), "utf-8"));
//            #
//            这里主要是涉及中文
            //            这里主要是涉及中文
            //BufferedReader in = new BufferedReader(new FileReader("d:\\1.txt")));
            //写入相应的文件
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\xcit\\Desktop\\drop.sql"), "utf-8"));
            //BufferedWriter out = new BufferedWriter(new FileWriter("d:\\2.txt"))；
            //读取数据
            //循环取出数据
            String str = null;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
                if (str.toLowerCase().trim().startsWith("insert") && str.toLowerCase().contains("into")) {

                } else if (str.toUpperCase().trim().startsWith("DROP")) {
                    out.write(str);
                    out.newLine();
                } else if (str.toUpperCase().trim().startsWith("ALTER TABLE")) {
                } else {//写入相关文件
                }
            }

            //清楚缓存
            out.flush();
            //关闭流
            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
