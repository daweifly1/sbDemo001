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

        String fileDir = "D:\\opt";
        int maxRows = 40000;
        splitFile(fileDir, maxRows, "D:\\opt\\target");
    }

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
