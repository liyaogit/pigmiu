package com.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pigmiu.dto.Animal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: yli
 * Date: 2017/8/8
 * Time: 13:00
 */
public class JsonTest {

    @Test
    public void testFastjsonNull(){
        String n = JSON.toJSONString(null);
        System.out.println(n);

        Animal animal = JSONObject.parseObject("null", Animal.class);
//        System.out.println(user.getName());

        Animal uu = new Animal();
        uu.setName("heihie");
        String u = JSON.toJSONString(uu);
        JSONObject userJsonObject = JSON.parseObject(u);
        JSONObject hdc =  userJsonObject.getJSONObject("hdc");
        System.out.println(""+hdc);
        if (null!=hdc){
            System.out.println("mab"+hdc);
        }

    }

    @Test
    public void testJsonWork(){
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        List<String> priorityList = new ArrayList<String>();
        priorityList.add("10000");
        priorityList.add("19999");
        map.put("priority",priorityList);

        List<String> activityType = new ArrayList<String>();
        activityType.add("1");
        activityType.add("3");
        map.put("activityPattern",activityType);

        List<String> advanceType = new ArrayList<String>();
        advanceType.add("BAIDU");
        advanceType.add("WEIPIAO");
        advanceType.add("WANDA");
        map.put("advancePay",advanceType);

        String n = JSON.toJSONString(map);
        System.out.println(n);
    }
}
