package com.devi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by hzchendawei on 2018/8/9.
 */
public class TxtFile {


    public static void main(String[] args) {
//        processSplitFile();

        processXMLMapper();
    }

    private static void processXMLMapper() {
        String tables = "ius_account,ius_profile,ius_account,ius_auth,ius_department,ius_menu,ius_menu_auth,ius_menu_bak,ius_password,ius_profile,ius_role,ius_role_auth,ius_role_menu,ius_template,ius_tmp_auth,ius_tmp_menu,ius_user_roles,ius_workspace";
        String t[] = tables.split(",");

        File dir = new File("F:\\private\\auth-server\\src\\main\\resources\\mybatis\\mysql-mapper");
        if (!dir.exists() || !dir.isDirectory()) {
            throw new RuntimeException("目录非法");
        }
        String target = "D:\\opt";

        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.getName().contains(".xml")) {
                doXmlMapper(t, f, target);
            }
        }
    }

    private static void doXmlMapper(String[] t, File file, String target) {
        if (null == t || t.length < 1) {
            throw new RuntimeException(" error");
        }

        FileWriter writer = null;
        FileReader reader = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            reader = new FileReader(file);
            String str = null;
            br = new BufferedReader(reader);
            String fileName = "D:\\opt\\" + file.getName();

            File newFile = new File(fileName);
            writer = new FileWriter(newFile, true);
            bw = new BufferedWriter(writer);


            while ((str = br.readLine()) != null) {
                for (String tt : t) {
                    if (str.toLowerCase().contains(tt)) {
                        str = str.replaceAll("(?i)"+tt, tt.toUpperCase());
                    }
                }
                str+="\n";
                bw.write(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != br) {
                    br.close();
                }
                if (null != reader) {
                    reader.close();
                }
                if (null != bw) {
                    bw.close();
                }
                if (null != writer) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void processSplitFile() {
        String fileDir = "D:\\opt";
        int maxRows = 40000;
        splitFile(fileDir, maxRows, "D:\\opt\\target");

    }

    /**
     * 将指定目录下txt文件按成行拆分成多个小文件
     *
     * @param fileDir
     * @param maxRows
     * @param s
     */
    private static void splitFile(String fileDir, int maxRows, String s) {
        File dir = new File(fileDir);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new RuntimeException("目录非法");
        }
        File[] files = dir.listFiles();
        if (null == files || fileDir.length() < 1) {
            throw new RuntimeException("目录非法");
        }
        for (File f : files) {
            if (f.getName().contains(".txt")) {
                doSplitFile(maxRows, f, s);
            }
        }

    }

    private static void doSplitFile(final int maxRows, File file, String target) {
        FileWriter writer = null;
        FileReader reader = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            reader = new FileReader(file);
            String str = null;
            br = new BufferedReader(reader);

            String fileName = file.getName().replace(".txt", "");
            String fistLine = null;
            int row = 0;
            while ((str = br.readLine()) != null) {
                StringBuffer sb = new StringBuffer();
                if (0 == row % maxRows) {
                    if (null != bw) {
                        bw.close();
                    }
                    if (null != writer) {
                        writer.close();
                    }
                    System.out.println("=============" + row);
                    File newFile = new File(target + "/" + fileName + (row / maxRows) + ".txt");
                    // 这里的true，是以追加的方式写
                    writer = new FileWriter(newFile, true);
                    bw = new BufferedWriter(writer);
                    if (null != fistLine) {
                        sb.append(fistLine);
                        row++;
                    }
                }
                sb.append(str + "\n");
                if (null == fistLine) {
                    fistLine = sb.toString();
                }
                bw.write(sb.toString());
                row++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != br) {
                    br.close();
                }
                if (null != reader) {
                    reader.close();
                }
                if (null != bw) {
                    bw.close();
                }
                if (null != writer) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
