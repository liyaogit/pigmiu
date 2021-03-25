package com.pigmiu.jvm;

import org.junit.Test;

/**
 * @Auther: yli
 * @Date: 2018/8/29 16:07
 * @Description:
 */
public class ConstantPoolTest {

    @Test
    public void StringIntern(){
        //intern:String首次出现,常量池记录。若常量池包含，返回常量池的引用
        String str1 = new StringBuffer("我").append("上王者了").toString();
        System.out.println(str1.intern() == str1);  //返回 true

        String str2 = new StringBuffer("java").toString();
        System.out.println(str2.intern() == str2);  //返回 false
    }
}
