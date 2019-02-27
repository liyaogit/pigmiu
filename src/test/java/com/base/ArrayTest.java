package com.base;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayTest {
    @Test
    public void testArrays(){
        String contents ="取票号:112345";
        for(String content : contents.split("\\|")){
            String[] code = content.split(":");
            System.out.println(code[0] +"," + code[1]);
        }
    }

    @Test
    public void setToString(){
        Set<Long> set = new HashSet<Long>();
        set.add(1L);
        set.add(2L);

        String setString = StringUtils.join(set.toArray(),";");
        String setJson = JSON.toJSONString(set.toArray());
        System.out.println(setString);
    }


    @Test
    public void ArrayToString(){
        List<String> list = new ArrayList<String>();
        list.addAll(null);
        list.add("2");

        //String setString = StringUtils.join(set.toArray(),";");
        String json = JSON.toJSONString(list.toArray());
        System.out.println(json);
    }

    @Test
    public void testC(){
        long begin = System.currentTimeMillis();
        List<String> likeList = new ArrayList();
        likeList.add("1");
        likeList.add("2");
        likeList.add("4");
        likeList.add("9");
        likeList.add("3");
        likeList.add("2");
        likeList.add("8");
        likeList.add("9");
        likeList.remove(0);
        for (String like : likeList){
            int i = (int)Math.random() * 9;
            System.out.println(likeList.get(i));
        }

    }

    @Test
    public void testModificationExcepiton(){
        List<String> list1 = new ArrayList();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        List<String> list2 = new ArrayList();
        list2.add("1");
        list2.add("2");
        list2.add("3");


        List<String> list3 = new ArrayList();
        list3.addAll(list1);

        for (String ll : list2){
            for (String l : list1){
                if (l.equals(ll)){
                    list2.remove(ll);
                    list1.remove(l);
                    break;
                }
            }


        }
        list3.addAll(list2);
        System.out.println(list3);

    }
}
