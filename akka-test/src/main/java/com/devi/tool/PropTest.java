package com.devi.tool;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * Created by hzchendawei on 2018/3/15.
 */
public class PropTest {

    private static final Pattern KAOLA_HOST_PATTERN = Pattern.compile("^https??://[^/]*?\\.kaola\\.com(\\.hk)??([/?]|$)(.*)?"); // 防止出现类似http(s)://www.baidu.com/www.kaola.com的钓鱼网站

    private static final Pattern NETEASE_HOST_PATTERN = Pattern.compile("^https??://[^/]*?\\.netease\\.com/.*");
    public static void main(String[] args) {
//        String target="http://rd.da.netease.com/redirect?t=58e051c7b7433c80&p=e17a6cd0&proId=1024&target=https%3A%2F%2Fwww.kaola.com%2Factivity%2Fdetail%2F30953.shtml%3Ftag%3Dea467f1dcce6ada85b1ae151610748b5";
//        if (NETEASE_HOST_PATTERN.matcher(target).find() || KAOLA_HOST_PATTERN.matcher(target).find()) {
//            System.out.println("ddd");
//        }

        BabyPlanUrlVO vo=new BabyPlanUrlVO();
        vo.setN(BigDecimal.ZERO);

        if(vo.getN().add(new BigDecimal("2")).compareTo(BigDecimal.ONE)>0){

        }

        if(vo.getN().add(new BigDecimal("2")).compareTo(BigDecimal.ONE)>0){

        }

        System.out.println(vo);



    }
}
