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
                "\t\"id\": \"dfbef09efe1644ea3a7596f6ab49a3a1\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.1-20181109.181359-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea56d76c84ddc77061\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.1-20181110.181356-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906406a2c007709322e\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.1-20181115.181401-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebc826beab9d074001\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.1-20181116.181407-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eae2bb2b8b74715354\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.1-20181117.181412-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f56d4579ea7c150f1\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.1-20181120.181401-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906b5f6ae5927f02678\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.1-20181126.181358-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb24a21464d2231655\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.1-20181127.181359-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebf123b66a8494c661\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.1-20181109.181356-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebed5b81e827272538\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.1-20181110.181353-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390ffe0dd79f6eaf7b49\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.1-20181115.181357-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906918680bede954dff\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.1-20181116.181403-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb07d7bae550b1c2de\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.1-20181117.181408-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea2e4ba98f2eb7a16f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.1-20181120.181358-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fb26bb4af61ecec5e\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.1-20181126.181354-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9062fbe76e9261cd598\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.1-20181127.181355-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906a37fb996058decbf\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.1-20181110.181349-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea84b7b2c4ca75b7d0\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.1-20181115.181353-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f555520f75f421801\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.1-20181116.181400-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906e7b6d279c3da0792\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.1-20181117.181405-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb861be5863cec6cf8\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.1-20181120.181355-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea672767d8680bcfe8\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.1-20181126.181351-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fb73e29474352e325\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.1-20181127.181352-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb8de2319672721468\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"1.0.1-20181110.181307-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f2a4b32391abcf933\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"1.0.1-20181115.181307-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906ea7f301157daa054\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"1.0.1-20181116.181306-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebf662ab85b466a8cb\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"1.0.1-20181117.181306-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea034b926028eb431c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"1.0.1-20181120.181307-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fea3abca594c04099\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"1.0.1-20181126.181307-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea90615fea695c1bb2f46\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"1.0.1-20181127.181307-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea90633710e54b02651b0\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"1.0.1-20181109.181324-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9069bc2d1897b77e54f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"1.0.1-20181110.181322-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea6969853eeb10f81f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"1.0.1-20181115.181324-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f1a0a0d3b18b57096\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"1.0.1-20181116.181333-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9063bb59d79cbf3a249\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"1.0.1-20181117.181338-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb4d1d8d83c7f090ce\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"1.0.1-20181120.181326-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea4ea232d607a8cebf\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"1.0.1-20181126.181324-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fe5e59883687aa7f1\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"1.0.1-20181127.181323-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fa0f64bbfc7309b47\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"1.0.1-20181109.181316-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fbe248f7db519d1cc\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"1.0.1-20181110.181315-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb73edd00b1a1e921a\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"1.0.1-20181115.181316-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ead2a2f014aae3d90c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"1.0.1-20181116.181326-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f33be23d9b41f2c24\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"1.0.1-20181117.181331-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9063535dc04dd820299\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"1.0.1-20181120.181319-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb3c837c57358b1716\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"1.0.1-20181126.181316-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea40681486c6a768b6\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"1.0.1-20181127.181316-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb5d569a0e923421b1\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"1.0.1-20181109.181333-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebcadfadb6956c2611\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"1.0.1-20181110.181330-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f77f3b1b7c1ea54d9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"1.0.1-20181115.181332-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9064b63c952df9876b4\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"1.0.1-20181116.181340-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb6cdaf01e9758e92b\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"1.0.1-20181117.181346-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea14a1ea2ea3e3a03d\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"1.0.1-20181120.181334-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f53be83228890566d\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"1.0.1-20181126.181331-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9065823036e646c86f5\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"1.0.1-20181127.181331-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eaa90fcb9916aab0b9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"1.0.1-20181109.181343-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea5ec98928e61d5424\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"1.0.1-20181110.181339-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9061c6838bff4fc9f37\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"1.0.1-20181115.181343-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb549c0279be99eac8\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"1.0.1-20181116.181350-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eaaee2d24e87c21f21\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"1.0.1-20181117.181356-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f15185f88538f1031\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"1.0.1-20181120.181344-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906062e79e20820361c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"1.0.1-20181126.181341-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb7a3c30f7b5214855\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"1.0.1-20181127.181341-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f6edf4f3b9220c724\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"1.0.1-20181109.181351-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f088f60271799b5ca\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"1.0.1-20181110.181347-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb87333bd558df4623\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"1.0.1-20181115.181351-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea8d0f1c2c0f211bb9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"1.0.1-20181116.181358-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f62b5289ad4e53d39\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"1.0.1-20181117.181403-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9064aeb4b0d7187f2f9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"1.0.1-20181120.181352-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb12110ced35760951\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"1.0.1-20181126.181349-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea8946985615c06cdc\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"1.0.1-20181127.181350-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea6852083ac435611b\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"1.0.1-20181109.181312-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eac8908e0c4e43f927\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"1.0.1-20181110.181311-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea90611e537ce4a914401\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"1.0.1-20181115.181312-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb3aa480c0ba2e9896\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"1.0.1-20181116.181321-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea2d930e1c4d1c2659\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"1.0.1-20181117.181327-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fab5bdfe8a3feda47\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"1.0.1-20181120.181315-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9068e441df61c59a1e4\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"1.0.1-20181126.181313-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb80762cada5e3d346\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"1.0.1-20181127.181312-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f2df8869898cff272\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"1.0.1-20181115.181421-2\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906c94a466bd4fed41d\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"1.0.1-20181116.181429-3\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebc9eda148f0a641b1\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"1.0.1-20181117.181433-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eac7b6b74ded8c1453\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"1.0.1-20181120.181422-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390feff9f49c14bdc0f6\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"1.0.1-20181126.181424-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906d990e0f9f25ae08d\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"1.0.1-20181127.181440-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fe8b22436f4b665da\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.1-20181109.181406-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fe47e68f4fa7f46c2\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.1-20181110.181402-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb9337e0679534ce6b\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.1-20181115.181407-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eacc3df96061f86526\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.1-20181116.181413-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fe8c9af7155458d42\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.1-20181117.181419-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9062f96f8db3cae42d1\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.1-20181120.181407-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebcced9ea370505690\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.1-20181126.181404-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eabd9902e477bc62cc\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.1-20181127.181407-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906636ec1b0e107d6f9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181109.181414-4\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9063366dfaef923eebd\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181110.181410-5\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea6d62f28df0573917\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181115.181416-6\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f8486bf4514da3b9b\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181116.181422-7\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9063f76beec8b023aa6\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181117.181428-8\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb3f3ea44a383ac7a3\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181120.181416-9\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f75eb6831de1f701c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181121.072511-10\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebebe46e72aa62de7e\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181121.074344-11\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea0c644a3e223445c7\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181121.075424-12\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea905ac964fb7461a3\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181126.181414-13\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f17160b7f9244c8b2\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-20181127.181416-14\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea90681cc68523c893997\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin.ufast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"1.0.1-CNPC-20181121.072850-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea12e48c028fafcfb3\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"0.0.3-20181106.181308-285\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9065be56d1560856925\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"0.0.3-20181106.181350-283\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fc0d23885abded9f2\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.3-20181106.181313-295\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906022bceba8a16353b\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20181108.023402-358\",\n" +
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
