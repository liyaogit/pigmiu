package com.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yli
 * @Date: 2018/7/10 11:30
 * @Description:
 */
public class HttpUtil {
    private static final CloseableHttpClient httpclient;
    public static final String CHARSET = "UTF-8";


    static{
        RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(3000).build();
        httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }


    /**
     * HTTP Get 获取内容
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数
     * @return 页面内容
     */
    public static String sendGet(String url, Map<String, Object> params) throws ParseException, UnsupportedEncodingException, IOException {

        if(params !=null && !params.isEmpty()){

            List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());

            for (String key :params.keySet()){
                pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
            url +="?"+ EntityUtils.toString(new UrlEncodedFormEntity(pairs), CHARSET);
        }

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode !=200){
            httpGet.abort();
            throw new RuntimeException("HttpClient,error status code :" + statusCode);
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, "UTF-8");
            EntityUtils.consume(entity);
            response.close();
            return result;
        }else{
            return null;
        }
    }


    /**
     * HTTP Post 获取内容
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数
     * @return 页面内容
     * @throws IOException
     */

    public static String sendPost(String url, Map<String, Object> params) throws IOException {

        List<NameValuePair> pairs = null;
        if (params != null && !params.isEmpty()) {
            pairs = new ArrayList<NameValuePair>(params.size());
            for (String key : params.keySet()) {
                pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
        }
        HttpPost httpPost = new HttpPost(url);
        if (pairs != null && pairs.size() > 0) {
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
        }
        CloseableHttpResponse response = httpclient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            httpPost.abort();
            throw new RuntimeException("HttpClient,error status code :" + statusCode);
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            response.close();
            return result;
        }else{
            return null;
        }
    }


}
