package com.devi.tool;

/**
 * Created by hzchendawei on 2018/3/15.
 */
public class PropTest {

    public static void main(String[] args) {
        String prop = "solo.maxTotal=\n" +
                "solo.maxIdle=10\n" +
                "solo.minIdle=5\n" +
                "solo.maxWaitMillis=500\n" +
                "solo.clientName=element\n" +
                "solo.timeout=500\n" +
                "solo.connectionTimeout=500\n" +
                "solo.clusterKey=kaola_element_compose_level1";

        String[] ss = prop.split("\n");
        for (String s : ss) {
            if (s.contains("=")) {
                String s1 = s.substring(0, s.indexOf("="));
                String s2 = s1 + "=${" + s1 + "}";
                System.out.println(s2);
            }
        }


    }
}
