package com.base;

import org.junit.Test;

/**
 * User: yli
 * Date: 2017/9/4
 * Time: 17:23
 */
public class BitTest {
    @Test
    public void testBit(){
        int x = 6;
        //i = ~i;  字节组合取反
        int y = 10;
        System.out.println(x + "   二进制:" + Integer.toBinaryString(x));
        System.out.println(y + "   二进制:" + Integer.toBinaryString(y));
        System.out.println("x & y:" + Integer.toBinaryString(x & y));
        System.out.println("x | y:" + Integer.toBinaryString(x | y));
        System.out.println("x ^ y:" + Integer.toBinaryString(x ^ y));  //相同返回0,否则返回1

        int i = -11;
        System.out.println(i + "   二进制:" + Integer.toBinaryString(i));
        System.out.println("i右移两位(>> 右移运算符)" + Integer.toBinaryString(i>>2)); //左边补0,首位不变,正负号不变
        System.out.println("i右移两位(>>> 无符号右移运算符)" + Integer.toBinaryString(i>>>2)); //左边全补0,正负号可能变化
        System.out.println("i左移两位(<< 左移运算符)" + Integer.toBinaryString(i<<2)); //右边全补0,正负号可能变化
    }
}
