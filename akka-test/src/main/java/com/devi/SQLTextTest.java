package com.devi;

import java.io.*;

/**
 * Created by hzchendawei on 2018/4/12.
 */
public class SQLTextTest {

    public static void main(String[] args) {
        String s = ",";

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\xcit\\Desktop\\SCM_ABNORMAL_IN.sql"), "utf-8"));
//            #
//            这里主要是涉及中文
            //            这里主要是涉及中文
            //BufferedReader in = new BufferedReader(new FileReader("d:\\1.txt")));
            //写入相应的文件
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\xcit\\Desktop\\ttt.sql"), "utf-8"));
            //BufferedWriter out = new BufferedWriter(new FileWriter("d:\\2.txt"))；
            //读取数据
            //循环取出数据
            String str = null;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
                if (str.toLowerCase().contains("insert") && str.toLowerCase().contains("into")) {

                } else {
                    //写入相关文件
                    out.write(str);
                }
                out.newLine();
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
