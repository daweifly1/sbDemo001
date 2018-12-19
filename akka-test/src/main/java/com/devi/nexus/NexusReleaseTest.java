package com.devi.nexus;

import com.devi.tool.util.FastJsonUtil;
import okhttp3.*;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by hzchendawei on 2018/4/12.
 */
public class NexusReleaseTest {

    public static void main(String[] args) {

        //先根据接口找到列表
        String s = "[{\n" +
                "\t\"id\": \"76d7d7e4186a390fc032dd1079cd8995\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"bkrwin.archetype\",\n" +
                "\t\"name\": \"starter-project-archetype\",\n" +
                "\t\"version\": \"1.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9068d11db1e750f7ed3\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"bkrwin.archetype\",\n" +
                "\t\"name\": \"starter-service-archetype\",\n" +
                "\t\"version\": \"1.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f639c754d980b6088\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"com.alipay\",\n" +
                "\t\"name\": \"alipay-sdk-java\",\n" +
                "\t\"version\": \"20180104135026\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f4ff1730bac36afae\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"com.bkh\",\n" +
                "\t\"name\": \"ufast-gen-code\",\n" +
                "\t\"version\": \"1.1.0\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea637fbf8c9658e1bd\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.archetype\",\n" +
                "\t\"name\": \"starter-project-archetype\",\n" +
                "\t\"version\": \"1.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebc80880a63b0b948c\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.archetype\",\n" +
                "\t\"name\": \"starter-service-archetype\",\n" +
                "\t\"version\": \"1.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906129555e744090d6a\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"com.bkw.ecp.fl\",\n" +
                "\t\"name\": \"crcc-financial-leasing-server\",\n" +
                "\t\"version\": \"1.5.7.RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea92eca766ac2e53fc\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"com.github.wxpay\",\n" +
                "\t\"name\": \"WXPay-SDK-Java\",\n" +
                "\t\"version\": \"0.0.4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea816192113bc2a7ab\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"com.sap\",\n" +
                "\t\"name\": \"jco\",\n" +
                "\t\"version\": \"3.0\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb9f6f49b9184be015\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"com.youbang.ecp\",\n" +
                "\t\"name\": \"nju-charging-service\",\n" +
                "\t\"version\": \"1.0-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebb03844d64034aab0\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"0.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fee4c50a6b9d2717d\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"0.0.2-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea4af8331254b56bb4\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.archetype\",\n" +
                "\t\"name\": \"starter-project-archetype\",\n" +
                "\t\"version\": \"0.0.3-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb95220f7acc817a10\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.archetype\",\n" +
                "\t\"name\": \"starter-project-archetype\",\n" +
                "\t\"version\": \"0.0.4-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906b8a4651c5e4a6578\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.archetype\",\n" +
                "\t\"name\": \"starter-service-archetype\",\n" +
                "\t\"version\": \"0.0.2-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f582a9caca24fbf26\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.archetype\",\n" +
                "\t\"name\": \"starter-service-archetype\",\n" +
                "\t\"version\": \"0.0.3-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea3c45681348c2bc78\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.archetype\",\n" +
                "\t\"name\": \"starter-service-archetype\",\n" +
                "\t\"version\": \"0.0.4-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebc78eba8e52e77291\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"0.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9068901491cb0d7d016\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"0.0.2-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f5d690fac2e4c1e03\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"0.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb2e05a7f6f683ae74\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"0.0.2-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea1b538653844c2ffe\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"0.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb5edf1cd4c58da872\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"0.0.2-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f6fb2e3fdfdd5a789\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"0.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eaf069612b518964d1\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"0.0.2-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9068ea49bc734f832e7\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"0.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f6ccbb72660f5ed89\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"0.0.2-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea787b1bdb5bd3df99\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906b7a2133f06fd901c\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.2-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebbcda84fb47d0fd77\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"0.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9068124c1421e6e4dfd\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"0.0.2-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f54fc2a950c7d8cd2\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.1-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb283b0b36acd1fe8b\",\n" +
                "\t\"repositoryName\": \"maven-releases\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.2-RELEASE\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}]";


        List<NexusListData> list = FastJsonUtil.parseList(s, NexusListData.class);
        System.out.printf(list.get(0).toString());

        if (!CollectionUtils.isEmpty(list)) {
            File dpan = new File("d://maven-releases");
            if (!dpan.exists()) {
                dpan.mkdir();
            }
            for (NexusListData data : list) {
                String ss = getCulData(data);

                List<NexusResult> ll = FastJsonUtil.parseList(ss, NexusResult.class);
                if (!CollectionUtils.isEmpty(ll)) {
                    NexusResult r = ll.get(0);
                    if (null != r && null != r.getResult() && !CollectionUtils.isEmpty(r.getResult().getData())) {
                        for (NexusResultItemData d : r.getResult().getData()) {
                            dowload(d);
                        }
                    }
                }
            }
        }

    }

    private static void dowload(NexusResultItemData d) {

        if (null == d || null == d.getName() || !(d.getName().contains(".jar") || !d.getName().contains(".pom"))) {
            return;
        }
        int s = d.getName().lastIndexOf("/");
        String fileName = d.getName().substring(s + 1);
        File file = new File("d:\\maven-releases", fileName);// 设置路径
        if (file.exists()) {
            return;
        }

        OkHttpClient client = new OkHttpClient();

        //bkw/fast/hage/changjietong/1.0.0-SNAPSHOT/changjietong-1.0.0-20180918.040157-1-sources.jar

        Request request = new Request.Builder()
                .url("http://192.168.2.102:8081/repository/maven-releases/" + d.getName())
                .get()
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "f1c647a6-31d4-4da9-b1d4-eb7571f95240")
                .build();
        InputStream is = null;//输入流
        FileOutputStream fos = null;//输出流
        try {
            Response response = client.newCall(request).execute();
            is = response.body().byteStream();//获取输入流
            long total = response.body().contentLength();//获取文件大小
            if (is != null) {

                fos = new FileOutputStream(file);
                byte[] buf = new byte[1024];
                int ch = -1;
                int process = 0;
                while ((ch = is.read(buf)) != -1) {
                    fos.write(buf, 0, ch);
                    process += ch;
                }

            }
            fos.flush();
            // 下载完成
            if (fos != null) {
                fos.close();
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (null != is) {
                    is.close();
                }
                if (null != fos) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    private static String getCulData(NexusListData data) {
        StringBuilder sb = new StringBuilder();

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "[{\"action\":\"coreui_Component\",\"method\":\"readComponentAssets\"," +
                "\"data\":[{\"page\":1,\"start\":0,\"limit\":25,\"filter\":[{\"property\":\"repositoryName\",\"value\":\""+data.getRepositoryName()+"\"},{\"property\":\"componentId\",\"value\":\"" + data.getId() + "\"}," +
                "{\"property\":\"componentName\",\"value\":\"changjietong\"},{\"property\":\"componentGroup\"," +
                "\"value\":\"" + data.getGroup() + "\"},{\"property\":\"componentVersion\"," +
                "\"value\":\"" + data.getVersion() + "\"}]}],\"type\":\"rpc\",\"tid\":9}," +
                "{\"action\":\"coreui_Component\",\"method\":\"readComponentAssets\"," +
                "\"data\":[{\"page\":1,\"start\":0,\"limit\":25,\"filter\"" +
                ":[{\"property\":\"repositoryName\",\"value\":\""+data.getRepositoryName()+"\"}," +
                "{\"property\":\"componentId\",\"value\":\"" + data.getId() + "\"}," +
                "{\"property\":\"componentName\",\"value\":\"" + data.getName() + "\"},{\"property\":\"componentGroup\",\"value\":\"" + data.getGroup() + "\"}," +
                "{\"property\":\"componentVersion\",\"value\":\"" + data.getVersion() + "\"}]}],\"type\":\"rpc\",\"tid\":10}]");
        Request request = new Request.Builder()
                .url("http://192.168.2.102:8081/service/extdirect")
                .post(body)
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.92 Safari/537.36")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "_ga=GA1.4.1945159969.1537248466; _gid=GA1.4.8837988.1537248466")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "585caaa7-d81d-4b0f-b33b-bd384b0c5ce9")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String tempResponse = response.body().string();
            sb.append(tempResponse);

            System.out.printf("\n   ===============" + tempResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
