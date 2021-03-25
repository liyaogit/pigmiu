package com.base;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: nuosong
 * @create: 2019-04-17 14:13
 **/

public class StringTest {
    @Test
    public void testBase(){
    String a ="";
    String[] l = a.split(":");
    System.out.println(l[0]);
    }


    @Test
    public void testStringJoin(){
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        String format = String.join(",", set);
        System.out.println(format);

        Map<String, Set<String>> map = new HashMap<>();
        map.put("hello", set);
        for (Map.Entry<String, Set<String>> entry : map.entrySet()){
            System.out.println(entry.getKey());

        }


    }
}
