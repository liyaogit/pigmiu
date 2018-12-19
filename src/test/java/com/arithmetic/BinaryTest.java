package com.arithmetic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: yli
 * @Date: 2018/12/18 11:59
 * @Description:
 */
public class BinaryTest {
    AtomicInteger atomicIntger = new AtomicInteger(0);

    @Test
    public void binaryDecimal(){
        int decimal = -5;
        String binary = "11";
        System.out.println(String.format("%d的二进制是%s", decimal, Binary.decimalToBinary(decimal)));
        System.out.println(String.format("%s的十进制是%d", binary, Binary.binaryToDecimal(binary)));
    }

    @Test
    public void shift() {

        int num = -53;
        int m = 1;
        System.out.println(String.format(" 数字 %d 的二进制向左移 %d 位是 %d", num, m, Binary.leftShift(num, m)));   // 测试向左移位
        System.out.println(String.format(" 数字 %d 的二进制逻辑右移 %d 位是 %d", num, m, Binary.rightShift(num, m)));   // 测试向右移位
        System.out.println(String.format(" 数字 %d 的二进制算数右移 %d 位是 %d", num, m, num >> m));   // 测试算数向右移位,正负不变

        System.out.println();

        m = 3;
        System.out.println(String.format(" 数字 %d 的二进制向左移 %d 位是 %d", num, m, Binary.leftShift(num, m)));   // 测试向左移位
        System.out.println(String.format(" 数字 %d 的二进制向右移 %d 位是 %d", num, m, Binary.rightShift(num, m)));   // 测试向右移位

    }

    @Test
    public void or() {

        int a = 17;
        int b = 20;
        System.out.println(String.format("%d的二进制是%s", a, Binary.decimalToBinary(a)));
        System.out.println(String.format("%d的二进制是%s", b, Binary.decimalToBinary(b)));
        System.out.println();

        System.out.println(String.format("%d与%d为%s", a, b, Binary.decimalToBinary(a & b)));
        System.out.println(String.format("%d或%d为%s",a, b, Binary.decimalToBinary(a | b)));
        System.out.println(String.format("%d异或%d为%s", a, b, Binary.decimalToBinary(a ^ b))); //相同为0
    }

}
