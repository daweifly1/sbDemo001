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
public class NexusTest {

    public static void main(String[] args) {
        String s = "[{\n" +
                "\t\"id\": \"76d7d7e4186a390f3c19f5fe9d9a3283\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.iot\",\n" +
                "\t\"name\": \"iot-server\",\n" +
                "\t\"version\": \"1.0.0-20190103.110215-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906b1ba8b110b8f9ce7\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.iot\",\n" +
                "\t\"name\": \"iot-server\",\n" +
                "\t\"version\": \"1.0.0-20190103.112319-2\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fd12ca3f2879f176c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"1.0.1-20190103.130702-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea3aa061702a445761\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.1-20190103.122748-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906a3121caa61afc6b8\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.1-20190103.130909-2\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906d815aface11c6d81\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkw.hage\",\n" +
                "\t\"name\": \"sign.cert\",\n" +
                "\t\"version\": \"1.0.0-20181222.151006-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fff23537e673c6846\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"center-server\",\n" +
                "\t\"version\": \"0.0.3-20190102.110637-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eaa0ed8875499992ff\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.0-20190102.110447-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea90687bb5e9cd3710054\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-druid-starter\",\n" +
                "\t\"version\": \"1.0.0-20190102.110658-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb7ca519acbf38af20\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.0-20190102.110445-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea90683f84e9a999c7a77\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.0-20190102.110442-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebaa5e272a5133741d\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"0.0.3-20190102.110224-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea09d863b8bc74ab38\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.flow\",\n" +
                "\t\"name\": \"flow-server-client\",\n" +
                "\t\"version\": \"0.0.3-20190119.083914-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea90648423cf0270f50fb\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"0.0.3-20190102.110305-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f208c43ab7b9c822e\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"0.0.3-20190102.110243-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ead26055e40939683f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-oauth2\",\n" +
                "\t\"version\": \"0.0.3-20190102.110627-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb6744276f4b29a63e\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"0.0.3-20190102.110344-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea9fd1e6277dc02a6d\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"0.0.3-20190102.110424-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fcc26a7de76d422d0\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"0.0.3-20190102.110430-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390faeb07f7c3d650ad9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.3-20190102.104423-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eabe9eea7a45c7282a\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.3-20190102.110226-2\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb7008df62b303b6fb\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"0.0.3-20190102.110558-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f8f13257749aace59\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.0-20190102.110520-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906ad3fcc843f054bb2\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"JCC-0.0.3-20190117.080330-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb75e69944f3914bf3\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"ynwl-0.0.3-20190104.021857-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f1fc8e458b4fbbba3\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"ynwl-0.0.3-20190123.063513-2\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb0df55b31930038ef\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"ynwl-0.0.3-20190131.093559-3\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea343867baa4ea299c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"ynwl-0.0.3-20190131.094934-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fec74a8d47faffd48\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"ynwl-0.0.3-20190131.101432-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906278b357c1d567463\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client-jcc\",\n" +
                "\t\"version\": \"0.0.3-20190102.104943-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906a34c74a8570f75b8\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client-jcc\",\n" +
                "\t\"version\": \"0.0.3-20190102.110528-2\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebb7d876cbae8cb52a\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"flow-server-client\",\n" +
                "\t\"version\": \"0.0.3-20190119.082531-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}]";
        List<NexusListData> list = FastJsonUtil.parseList(s, NexusListData.class);
        System.out.printf(list.get(0).toString());

        if (!CollectionUtils.isEmpty(list)) {
            File dpan = new File("d://maven-snapshots");
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

        if (null == d || null == d.getName() || !(d.getName().endsWith(".jar") || d.getName().endsWith(".pom"))) {
            return;
        }
        int s = d.getName().lastIndexOf("/");
        String fileName = d.getName().substring(s + 1);
        File file = new File("d:\\maven-snapshots", fileName);// 设置路径
        if (file.exists()) {
            return;
        }

        OkHttpClient client = new OkHttpClient();

        //bkw/fast/hage/changjietong/1.0.0-SNAPSHOT/changjietong-1.0.0-20180918.040157-1-sources.jar

        Request request = new Request.Builder()
                .url("http://192.168.2.102:8081/repository/maven-snapshots/" + d.getName())
                .get().addHeader("Cookie","NXSESSIONID=f463703e-f0e2-4423-9fc0-e119044a10e9")
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
                "\"data\":[{\"page\":1,\"start\":0,\"limit\":25,\"filter\":[{\"property\":\"repositoryName\",\"value\":\"maven-snapshots\"},{\"property\":\"componentId\",\"value\":\"" + data.getId() + "\"}," +
                "{\"property\":\"componentName\",\"value\":\"changjietong\"},{\"property\":\"componentGroup\"," +
                "\"value\":\"" + data.getGroup() + "\"},{\"property\":\"componentVersion\"," +
                "\"value\":\"" + data.getVersion() + "\"}]}],\"type\":\"rpc\",\"tid\":9}," +
                "{\"action\":\"coreui_Component\",\"method\":\"readComponentAssets\"," +
                "\"data\":[{\"page\":1,\"start\":0,\"limit\":25,\"filter\"" +
                ":[{\"property\":\"repositoryName\",\"value\":\"maven-snapshots\"}," +
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
