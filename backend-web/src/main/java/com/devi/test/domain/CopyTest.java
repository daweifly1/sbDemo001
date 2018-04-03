package com.devi.test.domain;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzchendawei on 2017/11/22.
 */
public class CopyTest {
    public static String httpPost(String url, Map<String, String> map, int i) throws IOException {
        //获取请求连接
        Connection con = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 MicroMessenger/6.5.2.501 NetType/WIFI WindowsWechat QBCore/3.43.691.400 QQBrowser/9.0.2524.400");


        con.header("Host", "tp1.hrbszf.com");
        con.header("Content-Length", "31");
        con.header("Accept", "application/json, text/javascript, */*; q=0.01");
        con.header("Content-Type", "application/x-www-form-urlencoded");
        con.header("Origin", "http://tp1.hrbszf.com");
        con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 MicroMessenger/6.5.2.501 NetType/WIFI WindowsWechat QBCore/3.43.691.400 QQBrowser/9.0.2524.400");
        con.header("X-Requested-With", "XMLHttpRequest");
        con.referrer("http://tp1.hrbszf.com/app/index.php?i=" + (i-1) + "&c=entry&rid=137&id=8646&do=view&m=tyzm_diamondvote&u=1030501&from=singlemessage&wxref=mp.weixin.qq.com");

        con.header("Accept-Encoding", "gzip, deflate");
        con.header("Accept-Language", "zh-CN,zh;q=0.8,en-us;q=0.6,en;q=0.5;q=0.4");
        con.header("Cookie", "PHPSESSID=04a4e951bfaad73f3da2524151e4ecfd; PHPSESSID=04a4e951bfaad73f3da2524151e4ecfd; Hm_lvt_08c6f5e17c0761a968c5658ccf6ff5ad=1511787335; Hm_lpvt_08c6f5e17c0761a968c5658ccf6ff5ad=1511787335");


        //遍历生成参数
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                //添加参数
                con.data(entry.getKey(), entry.getValue());
            }
        }
        con.method(Connection.Method.POST);
        con.cookie("PHPSESSID", "04a4e951bfaad73f3da2524151e4ecfd");
        con.cookie("PHPSESSID", "04a4e951bfaad73f3da2524151e4ecfd");
        con.cookie("Hm_lvt_08c6f5e17c0761a968c5658ccf6ff5ad", "1511787335");
        con.cookie("Hm_lpvt_08c6f5e17c0761a968c5658ccf6ff5ad", "1511787335");
        //插入cookie（头文件形式）
//        con.header("Cookie", "PHPSESSID=0cdbcaad6c2d0d5f86851e86cea8c89a; Hm_lvt_08c6f5e17c0761a968c5658ccf6ff5ad=1511783669; Hm_lpvt_08c6f5e17c0761a968c5658ccf6ff5ad=1511784698; PHPSESSID=0cdbcaad6c2d0d5f86851e86cea8c89a");
        Document doc = con.post();
        System.out.println(doc);
        return doc.toString();
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("latitude", "0");
        map.put("longitude", "0");
        map.put("verify", "0");

        for (int i = 130; i < 231; i++) {
            String url = "http://tp1.hrbszf.com/app/index.php?i=" + i + "&c=entry&ty=pv&rid=137&id=8646&do=Count&m=tyzm_diamondvote";
            String s = null;
            try {
                s = httpPost(url, map, i);
                System.out.println(s);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
