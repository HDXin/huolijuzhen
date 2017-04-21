package com.sudaotech.huolijuzhen.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by simon on 16-9-29.
 */
public class HttpClientUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

    public static String post(Map<String, String> headers, String url, String json) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String body = null;

        log.info("create http post:" + url);
        HttpPost post = new HttpPost(url);
        if (headers != null) {
            Set<String> strings = headers.keySet();
            for (String key : strings) {
                post.setHeader(key, headers.get(key));
            }
        }
        StringEntity s = new StringEntity(json, "UTF-8");
        s.setContentEncoding("UTF-8");
        s.setContentType("application/json");//发送json数据需要设置contentType
        post.setEntity(s);
        body = invoke(httpclient, post);

        log.info("result:" + body);
        return body;
    }

    public static String get(Map<String, String> headers, String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String body = null;

        log.info("create httppost:" + url);
        HttpGet get = new HttpGet(url);
        if (headers != null) {
            Set<String> strings = headers.keySet();
            for (String key : strings) {
                get.setHeader(key, headers.get(key));
            }
        }
        body = invoke(httpclient, get);
        log.info("result:" + body);

        return body;
    }

    private static String invoke(CloseableHttpClient httpclient,
                                 HttpUriRequest httpost) throws IOException {

        CloseableHttpResponse response = sendRequest(httpclient, httpost);

        String body = paseResponse(response);

        return body;
    }

    private static String paseResponse(CloseableHttpResponse response) throws IOException {
        log.info("get response from http server..");
        HttpEntity entity = response.getEntity();

        log.info("response status: " + response.getStatusLine());
        String body = EntityUtils.toString(entity, Contains.Base.encode);
        log.info(body);
        return body;
    }

    private static CloseableHttpResponse sendRequest(CloseableHttpClient httpclient,
                                                     HttpUriRequest httpost) {
        log.info("execute post...");
        CloseableHttpResponse response = null;

        try {
            response = httpclient.execute(httpost);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static HttpPost postForm(String url, Map<String, String> params) {

        HttpPost httpost = new HttpPost(url);
        if (params == null)
            return httpost;
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }

        try {
            log.info("set utf-8 form entity to httppost");
            httpost.setEntity(new UrlEncodedFormEntity(nvps, Contains.Base.encode));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return httpost;
    }

    /**
     * post请求
     *
     * @param url
     * @param json
     * @return
     */

    public static JSONObject doPost(Map<String, String> headers, String url, String json) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
            StringEntity s = new StringEntity(json);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            if (headers != null) {
                Set<String> strings = headers.keySet();
                for (String key : strings) {
                    post.setHeader(key, headers.get(key));
                }
            }
            log.info("request url:" + url);
            log.info("request json:" + json);
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                log.info(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
