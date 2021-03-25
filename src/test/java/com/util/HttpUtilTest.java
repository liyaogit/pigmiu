package com.util;

import com.pigmiu.utils.DecryptUtil;
import com.pigmiu.utils.HttpUtil;
import org.apache.http.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

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
}