/**
 *
 */
package com.devi;


import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 *
 * @author 盛宇伟 项目名称：NewYorkCloud
 *         类名称：RestHttpUtil
 *         类描述： 创建时间：2017年10月24日
 *         下午3:11:25 修改时间：2017年10月24日 下午3:11:25 修改备注：
 */
public class RestHttpUtil {
    private HashMap<String, String> mapParm;
    private String ip;
    private int port;
    protected String contextPath = null;
    private OkHttpClient okHttpClient = new OkHttpClient();

    public RestHttpUtil(String ip, int port, HashMap<String, String> mapParm) {
        this.ip = ip;
        this.port = port;
        this.mapParm = mapParm;
    }

    protected void setContextPath(String contextPath) {
        if (contextPath.startsWith("/")) {
            this.contextPath = contextPath;
        } else {
            this.contextPath = "/" + contextPath;
        }
    }

    private URI buildURI(String path, Map<String, String> parameters) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder().setScheme("http").setHost(this.ip);
        if (port != 80) {
            uriBuilder.setPort(port);
        }
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        if (contextPath == null) {
            uriBuilder.setPath(path);
        } else {
            uriBuilder.setPath(contextPath + path);
        }
        if ((parameters != null) && !parameters.isEmpty()) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (String name : parameters.keySet()) {
                nvps.add(new BasicNameValuePair(name, parameters.get(name)));
            }
            uriBuilder.setParameters(nvps);
        }
        return uriBuilder.build();
    }

    public String doPost(String path, Map<String, String> parameters) {
        Builder FormBuild = new FormBody.Builder();
        if ((parameters != null) && (!parameters.isEmpty())) {
            for (String name : parameters.keySet()) {
                if (name != null) {
                    FormBuild.add(name, parameters.get(name));
                }
            }
        }
        RequestBody requestBody = FormBuild.build();
        String url = "";
        try {
            url = buildURI(path, mapParm).toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        String result = "";
        try {
            Response response = call.execute();
            result = response.body().string();
            requestBody = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    public String doPostForDb(String path, Map<String, String> parameters) {
        Builder FormBuild = new FormBody.Builder();
//		if ((parameters != null) && (!parameters.isEmpty())) {
//			for (String name : parameters.keySet()) {
//				if(name!=null){
//					FormBuild.add(name, parameters.get(name));
//				}
//			}
//		}
        RequestBody requestBody = FormBuild.build();
        String url = "";
        if ((mapParm != null) && (!mapParm.isEmpty())) {
            for (String name : mapParm.keySet()) {
                if (name != null) {
                    parameters.put(name, mapParm.get(name));
                }
            }
        }
        try {
            url = buildURI(path, parameters).toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        String result = "";
        try {
            Response response = call.execute();
            result = response.body().string();
            requestBody = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }
}
