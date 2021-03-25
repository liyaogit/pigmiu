package com.pigmiu.tips;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 一些
 * @author: nuosong
 * @create: 2020-06-10 20:56
 **/

public class PitTest {

    @Test
    public void testFor(){
        List<String> list = Lists.newArrayList("1", "2", "3");
        for (String item : list){
            if ("1".equals(item)){
                list.remove(item);
            }
        }
        System.out.println(list.size());
    }

    @Test
    public void testArrays(){
        List<String> list = Arrays.asList("1", "2", "3");
        list.add("4");
        System.out.println(list.size());
    }

    @Test
    public void testThreadPool(){
        List<String> list = Arrays.asList("1", "2", "3");
        list.add("4");
        System.out.println(list.size());
    }

}
