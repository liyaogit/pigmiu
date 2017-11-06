package com.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: yli
 * Date: 2017/8/24
 * Time: 14:14
 */
public class ObjectTest {

    @Test
    public void testObject(){
        List<Object> objects = new ArrayList<Object>();
        objects.add("1");
        objects.add(new Integer(4));
//        Integer a =  objects.get(0);
        System.out.println(objects);
    }
}
