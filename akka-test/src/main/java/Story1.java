import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

public class Story1 {

    public static void main(String[] args) throws Exception {
        processMain("https://www.siluke.so/book/208/");
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
            if (null == lll || lll.size() < 1) {
                System.out.println("empty ee");
                continue;
            }
            String uurl = ee.get(0).attr("href");
            if(StringUtils.isBlank(uurl)){
                continue;
            }
            processText("https://www.siluke.so/book/208/" + uurl, i);
            i++;
        }
    }

    private static void processText(String url, int i) throws Exception {
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
            e.printStackTrace();
        }
    }

    private static void saveFile(String dir, String body, String fname) {
        try {
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
