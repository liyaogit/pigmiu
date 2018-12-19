package com.util;

import com.alibaba.fastjson.JSON;
import com.utils.DecryptUtil;
import com.utils.HttpUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: yli
 * @Date: 2018/7/10 11:45
 * @Description:
 */
public class HttpUtilTest {

    @Test
    public void testGet() throws ParseException, IOException {
        String testUrl01 = "https://m.maoyan.com/information/48733";
        Map<String, Object> params01 = new HashMap<String, Object>();
        params01.put("参数01", "对应的参数取值");
        params01.put("参数02", "对应的参数取值");
        String result = HttpUtil.sendGet(testUrl01, null);

        Date start = new Date();
        Document doc = Jsoup.parse(result);
        Element content = doc.selectFirst("article");
        //System.out.println(result);
        System.out.println(content);
        System.out.println(new Date().getTime()-start.getTime());

        Element frame = content.selectFirst("iframe");


        System.out.println(frame);
        System.out.println(new Date().getTime()-start.getTime());
    }

    @Test
    public void testMaoyan() throws ParseException, IOException {
        String reqUrl = "http://movie.test.maoyan.com/cmdata/gateway";
        Map<String, Object> params01 = getMaoyanParams();
        Date start = new Date();
        String result = HttpUtil.sendPost(reqUrl, params01);
        System.out.println(result);

        System.out.println(new Date().getTime()-start.getTime());

    }

    private Map<String, Object> getMaoyanParams(){
        LinkedHashMap<String,Object> params=new LinkedHashMap<>(8,1);
        params.put("api","cmdata.feedupdateinfo");

        Map<String, Object> data = new HashMap<>();
        data.put("offset",0);
        data.put("limit",10);
        data.put("timestamp",new Date().getTime());
        params.put("bizData", JSON.toJSONString(data));

        params.put("merCode","1000014");
        params.put("signType","MD5");
        params.put("timestamp",String.valueOf(new Date().getTime()/1000));
        params.put("version","1.0");
        params.put("signMsg",sign("key","A013F70DB97834C0A5492378BD76C53A",params));
        return params;
    }

    private static String sign(String key, String value,LinkedHashMap<String,Object> params){
        String paramsStr=mapToQueryString(params)+"&"+key+"="+value;
        return DecryptUtil.MD5(paramsStr);
    }

    public static String mapToQueryString(LinkedHashMap<String,Object> params) {

        StringBuilder sb = new StringBuilder();
        Iterator queryString = params.entrySet().iterator();
        while (queryString.hasNext()) {
            Map.Entry entry = (Map.Entry) queryString.next();

            String key = (String) entry.getKey();
            String value = (String) entry.getValue();

            if (value!=null) {
                sb.append(key).append("=").append(value).append("&");
            }

        }

        String qs = sb.toString();
        if (!StringUtils.isEmpty(qs)) {
            qs = qs.substring(0, qs.length() - 1);
        }

        return qs;
    }


    @Test
    public void testKaiYan() throws ParseException, IOException {
        String testUrl01 = "http://openapi.kaiyanapp.com/api/v1/videos";
        String id ="aM2ZW5vZ2JseM9rkJO1X2FzZm2Ot2Rm9I1k5YU1M";
        String key = "ksCey0rMDaOXWvh91IgWFl23ZhZeoW5p2l55Lk1";
        Map<String, Object> params01 = new HashMap<String, Object>();

        Calendar calendar = Calendar.getInstance();
        long timestamp = calendar.getTimeInMillis();
        calendar.add(Calendar.DAY_OF_YEAR, -10);
        long lastFetch = calendar.getTimeInMillis();

        String token = DecryptUtil.MD5(id + key + timestamp);

        params01.put("id", id);
        params01.put("timestamp", timestamp);
        params01.put("token", token);
        params01.put("page", 1);
        params01.put("lastFetch", lastFetch);
        String result = HttpUtil.sendGet(testUrl01, params01);

        String url = HttpUtil.sendGet("https://baobab.kaiyanapp.com/api/v1/playUrl?vid=132455&resourceType=video&editionType=default&source=aliyun&ptl=true", null);

        Date start = new Date();
        Document doc = Jsoup.parse(url);
        Element content = doc.selectFirst("article");
        //System.out.println(result);
        System.out.println(content);
        System.out.println(new Date().getTime()-start.getTime());

        Element frame = content.selectFirst("iframe");


        System.out.println(frame);
        System.out.println(new Date().getTime()-start.getTime());
    }


    @Test
    public void testZaker() throws ParseException, IOException {
        String testUrl01 = "http://iphone.myzaker.com/zaker/apps_telecom.php?for=zhangshangshenghuo";


        String url = HttpUtil.sendGet(testUrl01, null);

        Date start = new Date();
        Document doc = Jsoup.parse(url);
        Element content = doc.selectFirst("article");
        //System.out.println(result);
        System.out.println(content);
        System.out.println(new Date().getTime()-start.getTime());

        Element frame = content.selectFirst("iframe");


        System.out.println(frame);
        System.out.println(new Date().getTime()-start.getTime());
    }

    @Test
    public void testYiLan() throws ParseException, IOException {
        String testUrl01 = "https://openapi.yilan.tv/plat/getnewvideos";
        String key ="yly0fjkt6qv2";
        String token = "ptne3oga5hujjy36ohmo7dq725tyy71p";
        LinkedHashMap<String, Object> params01 = new LinkedHashMap<String, Object>();

        Calendar calendar = Calendar.getInstance();
        long timestamp = calendar.getTimeInMillis();
        calendar.add(Calendar.HOUR_OF_DAY, -24);
        long lastFetch = calendar.getTimeInMillis();

        params01.put("access_key", key);






        //params01.put("begin_time", "1542531793");
        params01.put("begin_time", String.valueOf(lastFetch/1000));
        //params01.put("end_time", "1542618193");
        params01.put("end_time", String.valueOf(timestamp/1000));

        params01.put("format", "");

        params01.put("ip", "");
        params01.put("model", "");
        params01.put("pg", "1");
        params01.put("platform", "0");
        params01.put("sid", "0");
        //params01.put("timestamp","1542618193");
        params01.put("timestamp",String.valueOf(new Date().getTime()/1000));

        params01.put("udid", "");
        params01.put("ver","1.0");
        params01.put("sign",sign("access_token",token,params01));

        String result = HttpUtil.sendGet(testUrl01, params01);

        String content = HttpUtil.sendGet("https://howto.yilan.tv/video/play?id=pbjDv84ary2N", null);

        String delete = HttpUtil.sendGet("https://openapi.yilan.tv/plat/getdelete", params01);


        Date start = new Date();
        //System.out.println(result);
        System.out.println(content);
        System.out.println(new Date().getTime()-start.getTime());

    }


}