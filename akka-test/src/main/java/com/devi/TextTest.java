package com.devi;

import org.apache.commons.lang.StringUtils;

/**
 * Created by hzchendawei on 2018/4/12.
 */
public class TextTest {

    public static void main(String[] args) {
        String s = "--zuul.routes.api-a.path=/cop/** --zuul.routes.api-a.service-id=copper-purchase --zuul.routes.api-b.path=/cos/** --zuul.routes.api-b.service-id=copper-server --zuul.routes.api-c.path=/jcs/** --zuul.routes.api-c.service-id=storage-server --zuul.routes.api-d.path=/ius/** --zuul.routes.api-d.service-id=fast-auth-server  --zuul.routes.api-e.path=/web/** --zuul.routes.api-e.service-id=copper-surface    --zuul.routes.api-f.path=/ss/** --zuul.routes.api-f.service-id=storage-server --fast.webfront.path=/root/jt_prop/dist --logging.file=logs/gateway.log --eureka.instance.ip-address=10.100.2.109";
        printProp(s);

//        printBootAppend(s);

    }

    private static void printProp(String s) {
        String[] ss=s.split("--");
        for (String sss:ss){
            if(StringUtils.isNotBlank(sss)&&sss.contains("=")){
                System.out.println(sss);
            }
        }
    }

}
