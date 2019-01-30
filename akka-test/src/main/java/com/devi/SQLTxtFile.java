package com.devi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by hzchendawei on 2018/8/9.
 */
public class SQLTxtFile {


    public static void main(String[] args) {
        File file = new File("D:\\opt\\ABNORMAL_IN.sql");

        FileWriter writer = null;
        FileReader reader = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            reader = new FileReader(file);
            String str = null;
            br = new BufferedReader(reader);
            String fileName = "D:\\opt\\result.txt";

            File newFile = new File(fileName);
            writer = new FileWriter(newFile, true);
            bw = new BufferedWriter(writer);

            String tableName = "";
            while ((str = br.readLine()) != null) {
                if (str.contains("CREATE TABLE") && str.contains("\"SCM\".\"")) {
                    tableName = str.substring(str.indexOf(".") + 2);
                    tableName = tableName.substring(0, tableName.indexOf("\""));
                    continue;
                }
                if (str.contains("NUMBER") && str.contains(",")) {
                    str = str.substring(0, str.lastIndexOf(","));
                    if (!(str.contains("NUMBER(") && str.contains(","))) {
                        continue;
                    }
                    String s = "alter table " + tableName + "  modify(" + str.replace("\"", "") + ");\n\n";

                    bw.write(s);
                    bw.flush();
                } else if (str.contains("NUMBER")) {
                    System.out.printf("==========="+str);
                    if (!(str.contains("NUMBER(") && str.contains(","))) {
                        continue;
                    }
                    String s = "alter table " + tableName + "  modify(" + str.replace("\"", "") + ");\n\n";

                    bw.write(s);
                    bw.flush();
                }

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


}
