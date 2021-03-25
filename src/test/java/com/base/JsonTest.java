package com.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.pigmiu.variety.dto.Animal;
import org.junit.Test;

import java.util.*;

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
        uu.setAge(11);
        uu.setFood(true);
        String u = JSON.toJSONString(uu);
        JSONObject userJsonObject = JSON.parseObject(u);
        JSONObject hdc =  userJsonObject.getJSONObject("hdc");
        System.out.println(""+hdc);
        if (null!=hdc){
            System.out.println("mab"+hdc);
        }

    }

    @Test
    public void testJsonToList(){
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();

    }

    @Test
    public void testJsonWork(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> priorityList = new ArrayList<String>();
        priorityList.add("10000");
        //priorityList.add("19999");
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

    @Test
    public void testJsonToObject(){
        String json = "{\"degrade\":\"\\\"Y\\\"\"}";
        JSONObject jsonObject = JSON.parseObject(json);
        String y = jsonObject.getString("degrade");
        Object j = JSON.parse(y);
        System.out.println(y);
        System.out.println(j);
    }

    @Test
    public void testJsonAndToString(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        System.out.println("--------Map toString--------------");
        System.out.println(map);
        System.out.println(JSON.toJSONString(map));

        Map<String, Set<String>> listMap = new HashMap<>();
        listMap.put("1", new HashSet<>(Lists.newArrayList("a", "b")));
        System.out.println("--------Map<String,List> toString--------------");
        System.out.println(listMap);
        System.out.println(JSON.toJSONString(listMap));
        System.out.println(listMap.keySet());

    }
}
