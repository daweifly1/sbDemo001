package com.devi.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hzchendawei on 2017/9/13.
 */
public class YunyinyueDownload {


    public static void main(String[] args) {
//        test1()

        String ss = "2";
        System.out.println(ss.equals(2 + ""));

    }


    public static String getAjaxCotnent(String url) throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("phantomjs.exe  D:/phantomjsFile/crawl2.js ");
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        while ((tmp = br.readLine()) != null) {
            sbf.append(tmp);
        }
        System.out.println(sbf.toString());
        return sbf.toString();
    }
}