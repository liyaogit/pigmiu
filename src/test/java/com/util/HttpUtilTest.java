package com.util;

import com.utils.HttpUtil;
import org.apache.http.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yli
 * @Date: 2018/7/10 11:45
 * @Description:
 */
public class HttpUtilTest {

    @Test
    public void testGet() throws ParseException, IOException {
        String testUrl01 = "http://iphone.myzaker.com/zaker/apps_telecom.php";
        Map<String, Object> params01 = new HashMap<>();
        params01.put("参数01", "对应的参数取值");
        params01.put("参数02", "对应的参数取值");
        String result = HttpUtil.sendGet(testUrl01, null);
        System.out.println(result);

    }

}