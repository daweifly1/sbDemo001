package com.devi;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hzchendawei on 2018/4/12.
 */
public class CommonTest {

    public static void main(String[] args) {
//        String ss = "httpxs://chendawei.top/dd.jpg";
//        boolean r = checkImgUrlValid(ss);
//        System.out.println(r);

//        String test = "hahahhehe sendCode\":\"12367890123rsdfsdfsdfdsahahhehe sendCode\":\"12367890123rsdfsdfsdfds";
//        test = regMatch(test, "sendCode\":\"([\\d]{8})([\\d]{3})");
//        System.out.println(test);


        String s = "...ddd!!!.??";

        System.out.println(removeLastSymbol(s));
    }

    private static String removeLastSymbol(String s) {
        String lastSymbol = null;
        Pattern patPunc = Pattern.compile("[, ; . ! ~ : ? ，；。！~ ：？]*$");
        Matcher matcher = patPunc.matcher(s);
        if (matcher.find()) {
            lastSymbol = matcher.group(0);
        }
        if (lastSymbol != null && s.endsWith(lastSymbol)) {
            s = s.substring(0, s.length() - lastSymbol.length());
        }
        return s;
    }

    public static String regMatch(String withinText, String regString) {
        String code = null;
        Pattern pattern = Pattern.compile(regString);
        Matcher matcher = pattern.matcher(withinText);
        if (matcher.find()) {
            matcher.reset();
            while (matcher.find()) {
                code = matcher.group(1);
                System.err.println("aaaa" + code);
                code = matcher.group(0);
                System.err.println("bbbb" + code);
                code = matcher.group(2);
                System.err.println("ccc" + code);
            }
        }
        return code;
    }

    private static boolean checkImgUrlValid(String urlString) {
        URI uri = null;
        try {
            uri = new URI(urlString);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        }

        if (uri.getHost() == null) {
            return false;
        }
        if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https")) {
            return true;
        }
        return false;
    }
}
