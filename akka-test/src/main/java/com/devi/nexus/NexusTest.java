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
                "\t\"id\": \"cf606f82560ea906f77565b3a0aaa14f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"bkw.fast.hage\",\n" +
                "\t\"name\": \"changjietong\",\n" +
                "\t\"version\": \"1.0.0-20180918.040157-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebb9f1be42c6dcd913\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"bkw.fast.hage\",\n" +
                "\t\"name\": \"changjietong\",\n" +
                "\t\"version\": \"1.0.0-20180918.040235-2\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f9c842a7250d61224\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin\",\n" +
                "\t\"name\": \"ynwl-service\",\n" +
                "\t\"version\": \"1.0.0-20180917.081832-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906c8367cb52e54a505\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin\",\n" +
                "\t\"name\": \"ynwl-service\",\n" +
                "\t\"version\": \"1.0.0-20180917.082824-2\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb92a7bd06f1f4d130\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkrwin\",\n" +
                "\t\"name\": \"ynwl-service\",\n" +
                "\t\"version\": \"1.0.0-20180917.083017-3\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea706653f45f84cbb1\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkw.hage\",\n" +
                "\t\"name\": \"changjietong\",\n" +
                "\t\"version\": \"1.0.0-20180918.041145-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f7c15f6cc374790d9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"com.bkw.hage\",\n" +
                "\t\"name\": \"sign.cert\",\n" +
                "\t\"version\": \"1.0.0-20180918.031855-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea0346d4bba5ef789d\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"center-server\",\n" +
                "\t\"version\": \"0.0.3-20180910.181437-21\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f9d321c345d2c70fd\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"center-server\",\n" +
                "\t\"version\": \"0.0.3-20180912.181440-22\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9062f629bfcfb044967\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"center-server\",\n" +
                "\t\"version\": \"0.0.3-20180913.181440-23\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb7d019ebd31522bd7\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"center-server\",\n" +
                "\t\"version\": \"0.0.3-20180914.181437-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea2eb664ab53a988ca\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"center-server\",\n" +
                "\t\"version\": \"0.0.3-20180915.181435-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb6b56984f41ecf245\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.0-20180910.181358-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eab747a51c2ac13574\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.0-20180912.181401-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fc8f718672e383c60\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.0-20180913.181358-26\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9067096ea6e7cb1aab8\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.0-20180914.181358-27\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb9db4b5a33380c90f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-config-starter\",\n" +
                "\t\"version\": \"1.0.0-20180915.181357-28\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f1e67cc22ceb88311\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-druid-starter\",\n" +
                "\t\"version\": \"1.0.0-20180910.181447-21\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906081ad074f833ca8e\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-druid-starter\",\n" +
                "\t\"version\": \"1.0.0-20180912.181449-22\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb494e9afa7621d3fc\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-druid-starter\",\n" +
                "\t\"version\": \"1.0.0-20180913.181450-23\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea719b7f294633b84b\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-druid-starter\",\n" +
                "\t\"version\": \"1.0.0-20180914.181446-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f4fd03b5eb25b36c5\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-druid-starter\",\n" +
                "\t\"version\": \"1.0.0-20180915.181445-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906000637c88e65376c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.0-20180910.181354-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb9378ba9456618a3b\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.0-20180912.181357-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea3a8f9a64e38e029c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.0-20180913.181354-26\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fd0e90b5e87f6b70a\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.0-20180914.181355-27\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906151e7c19eeb010a7\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-logging-starter\",\n" +
                "\t\"version\": \"1.0.0-20180915.181354-28\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f5c022c4327f56c83\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.0-20180910.181351-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906a69c3ec7b1602c3e\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.0-20180912.181354-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebe0b579224be75e01\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.0-20180913.181351-26\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eaf72c71b7723afec4\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.0-20180914.181352-27\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fd0e9018f1006e4cf\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"fast-spring-boot-starter\",\n" +
                "\t\"version\": \"1.0.0-20180915.181351-28\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9060edc80491acca84a\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"tdbc-pay\",\n" +
                "\t\"version\": \"1.0-20180910.083125-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb2195ef3e0d09f93e\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"tdbc-pay\",\n" +
                "\t\"version\": \"1.0-20180910.083635-2\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eaae98c4b2e8464c14\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"tdbc-pay\",\n" +
                "\t\"version\": \"1.0-20180910.084339-3\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fde77f677a0d59652\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-payment-parent\",\n" +
                "\t\"version\": \"1.0-20180910.084714-1\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea10d68e0823c52649\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"0.0.3-20180905.181308-252\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906b6ada4538c6890e5\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"0.0.3-20180910.181308-253\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebee5f878330f0433a\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"0.0.3-20180912.181308-254\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea6be9bfd87f7fefb3\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"0.0.3-20180913.181308-255\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f396b45a45fd777ef\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"0.0.3-20180914.181308-256\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9062f51488bac1af272\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast\",\n" +
                "\t\"name\": \"ufast-starter-parent\",\n" +
                "\t\"version\": \"0.0.3-20180915.181308-257\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f7d0786ea1abb2b2a\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"0.0.3-20180910.181324-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9064c910b20051332e0\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"0.0.3-20180912.181325-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb75ac6e512f7f1182\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"0.0.3-20180913.181324-26\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea3e0d63e64512cba9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"0.0.3-20180914.181325-27\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fc98536676a743dbe\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"config-server\",\n" +
                "\t\"version\": \"0.0.3-20180915.181324-28\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eacac3c0d13612567f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"0.0.3-20180910.181316-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f67f018cbda9c7c85\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"0.0.3-20180912.181317-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9061c1bcc85de755b8f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"0.0.3-20180913.181317-26\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb84e6e3a48ce0a403\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"0.0.3-20180914.181317-27\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea879bc95492c42a5b\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"eureka-server\",\n" +
                "\t\"version\": \"0.0.3-20180915.181317-28\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebf4883bc51f63a598\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-oauth2\",\n" +
                "\t\"version\": \"0.0.3-20180910.181428-21\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea276002c8489b4856\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-oauth2\",\n" +
                "\t\"version\": \"0.0.3-20180912.181431-22\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f630e80befbfd708d\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-oauth2\",\n" +
                "\t\"version\": \"0.0.3-20180913.181431-23\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9065b4651b91a4eb663\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-oauth2\",\n" +
                "\t\"version\": \"0.0.3-20180914.181427-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebd4ff361896c16602\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-oauth2\",\n" +
                "\t\"version\": \"0.0.3-20180915.181426-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9065d3ccac9156cc02b\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"0.0.3-20180910.181332-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb44a849b74cb21722\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"0.0.3-20180912.181333-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ead30f192f0370a5c2\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"0.0.3-20180913.181332-26\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f2015a1c4bccc52cf\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"0.0.3-20180914.181333-27\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906d7836bd045634849\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gateway-server\",\n" +
                "\t\"version\": \"0.0.3-20180915.181332-28\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb4e54ff6b5bb04a5c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"0.0.3-20180910.181342-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea005221b9368aa415\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"0.0.3-20180912.181343-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f955aaf102547a956\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"0.0.3-20180913.181341-26\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906fbc205e8f2c62980\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"0.0.3-20180914.181342-27\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb4dd90e6fe9c0d20f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service\",\n" +
                "\t\"version\": \"0.0.3-20180915.181342-28\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906148ee002cbe8097c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"0.0.3-20180905.181350-250\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea41a20401a29d84dd\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"0.0.3-20180910.181349-251\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f9827ac6110cd35bb\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"0.0.3-20180912.181351-252\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9061426e5b6f7f0eb83\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"0.0.3-20180913.181349-253\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebcdd98ae6735223aa\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"0.0.3-20180914.181350-254\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644eac808c1b836581d0f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"gen-service-client\",\n" +
                "\t\"version\": \"0.0.3-20180915.181349-255\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fa6c64ff9162c2550\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.3-20180905.181313-262\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb05e11e3cd2b32001\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.3-20180910.181313-263\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea845b72ae4ea9be7c\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.3-20180912.181313-264\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390ffeb364295b3bb201\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.3-20180913.181313-265\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9064b8d56228bede5fb\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.3-20180914.181313-266\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eba8063c35480053d3\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.infra\",\n" +
                "\t\"name\": \"misc\",\n" +
                "\t\"version\": \"0.0.3-20180915.181313-267\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9060d592e58ec3d9153\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"0.0.3-20180910.181418-21\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb6022546552b24e18\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"0.0.3-20180912.181421-22\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea7c4e5b2116f47fc4\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"0.0.3-20180913.181422-23\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f847f43ac50ccde50\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"0.0.3-20180914.181418-24\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea9061c87deaff2937e98\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.oauth2\",\n" +
                "\t\"name\": \"oauth2-server\",\n" +
                "\t\"version\": \"0.0.3-20180915.181416-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea54beb2a2cd13f649\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.0-20180910.181404-25\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390ff998a27bc6c329ba\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.0-20180912.181407-26\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906ec72c35321f6201d\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.0-20180913.181404-27\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb7875c5c93ccc0143\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.0-20180914.181404-28\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea0fcae3c06e83f3b9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server\",\n" +
                "\t\"version\": \"1.0.0-20180915.181403-29\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea317a21d79ab71129\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180907.060531-292\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390fb441f8c176c04f1e\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180910.181412-293\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906f9af3d39520848c7\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180911.012950-294\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebc866a5ad96b524b4\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180911.015624-295\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea84b0ca8e5d347090\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180911.022052-296\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea90666a8ef957b16616b\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180912.181417-297\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209ebad5867fa456537f4\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180912.181637-298\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"1c787a03db8209eb6f2a343ab9fb40b0\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180913.181413-299\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea530134b3d97c8a62\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180913.181638-300\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"dfbef09efe1644ea024ceea69b13b44f\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180914.181413-301\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390f3a756da34350aae9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180914.181743-302\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"76d7d7e4186a390ffdcc6151b6ba4abf\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180915.181412-303\",\n" +
                "\t\"format\": \"maven2\"\n" +
                "}, {\n" +
                "\t\"id\": \"cf606f82560ea906d2b3bb6f9f8f02c9\",\n" +
                "\t\"repositoryName\": \"maven-snapshots\",\n" +
                "\t\"group\": \"yb.ecp.fast.user\",\n" +
                "\t\"name\": \"auth-server-client\",\n" +
                "\t\"version\": \"0.0.3-20180915.181741-304\",\n" +
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

        if (null == d || null == d.getName() || !(d.getName().contains(".jar") || !d.getName().contains(".pom"))) {
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
