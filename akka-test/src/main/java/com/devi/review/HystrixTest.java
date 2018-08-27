package com.devi.review;

/**
 * Created by hzchendawei on 2018/8/21.
 */
public class HystrixTest {
    public static void main(String[] args) {
        String s = " {\"buttonConfig\":[{\"display\":\"\"true\"\",\"link\":\"http://mall.kaola.com/app/132733\",\"title\":\"进入店铺\"},{\"display\":\"\"true\"\",\"link\":\"http://m.kaola.com/coupon.html\",\"title\":\"查看优惠券\"}]} ";
        s = s.replace("\"\"true\"\"", "\"true\"");
        s = s.replace("\"\"false\"\"", "\"false\"");
        System.out.println(s);
    }
}
