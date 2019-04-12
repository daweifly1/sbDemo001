package com.devi.txt;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Story1 {
    private static Map<String, Integer> urlTimes = new HashMap<>();

    public static void main(String[] args) throws Exception {
        processMain("https://www.75txt.org/12/12861/");
    }

    private static void processMain(String url) throws Exception {
        Document doc = Jsoup.parse(new URL(url), 200000);
        if (null == doc) {
            System.out.println("blank");
            return;
        }
        saveFile("C:\\Users\\xcit\\Desktop\\temp\\", doc.body().toString(), "aa.txt");
        Element ll = doc.body().getElementById("list-chapterAll");
        if (null == ll) {
            System.out.println("blank ll");
            return;
        }
        Elements lll = ll.getElementsByClass("col-md-3");
        if (null == lll || lll.size() < 1) {
            System.out.println("empty lll");
            return;
        }
        int i = 100000;
        for (Element e : lll) {
            Elements ee = e.getElementsByTag("a");
            if (null == ee || ee.size() < 1) {
                System.out.println("empty ee");
                continue;
            }
            if (null == ee.get(0)) {
                System.out.println("empty ee");
                continue;
            }
            String uurl = ee.get(0).attr("href");
            if (StringUtils.isBlank(uurl)) {
                continue;
            }
            processText("https://www.75txt.org" + uurl, i);
            i++;
        }
    }

    private static void processText(String url, int i) throws Exception {
        if (i < 100122) {
            return;
        }
        try {
            if (StringUtils.isBlank(url)) {
                System.out.println("processText url null");
                return;
            }
            System.out.println("processText===" + url);
            Document doc = Jsoup.parse(new URL(url), 200000);
            if (null == doc) {
                System.out.println("processText doc null");
                return;
            }
            Element d = doc.getElementById("htmlContent");

            saveFile("C:\\Users\\xcit\\Desktop\\temp\\", d.toString(), i + ".txt");
        } catch (Exception e) {
            int t = 0;
            if (null != urlTimes.get(url)) {
                t = urlTimes.get(url);
            }
            System.out.println("t:" + t + "  url:" + url);
            if (t < 3) {
                t++;
                Thread.sleep(100 * t);
                urlTimes.put(url, t);
                processText(url, i);
            }
            e.printStackTrace();
        }
    }

    private static void saveFile(String dir, String body, String fname) {
        try {
            if (StringUtils.isBlank(body)) {
                return;
            }
            body = body.replace(" <br> &nbsp;&nbsp;&nbsp;&nbsp;", "").replace("<p class=\"text-danger text-center\">本章未完，点击下一页继续阅读</p>", "")
                    .replace("<br> --&gt;&gt;", "").replace("<div class=\"panel-body\" id=\"htmlContent\">", "")
                    .replace("<br> ", "").replace("</div>", "");
            //写入相应的文件
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dir + fname), "utf-8"));
            out.write(body);
            //清楚缓存
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
