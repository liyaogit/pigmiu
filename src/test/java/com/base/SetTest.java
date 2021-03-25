package com.base;

import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: nuosong
 * @create: 2019-05-05 17:04
 **/

public class SetTest {
    @Test
    public void formatDate(){
      Set<String> set = new HashSet<>();
      set.add("1");
      set.add("2");
      set.clear();
      System.out.println(set.size());
    }
}
