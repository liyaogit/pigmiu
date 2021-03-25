package com.pigmiu.algo;

import org.junit.Test;

/**
 * @Auther: yli
 * @Date: 2018/12/18 11:59
 * @Description:
 */
public class BinaryTest {

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


    @Test
    public void testCompareTime() {
        //位操作应用，验证奇偶数
        int even_cnt = 0, odd_cnt = 0;
        long start, end;

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {

            if((i & 1) == 0){
                even_cnt ++;
            }else{
                odd_cnt ++;
            }

        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(even_cnt + " " + odd_cnt);

        even_cnt = 0;
        odd_cnt = 0;

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {

            if((i % 2) == 0){
                even_cnt ++;
            }else{
                odd_cnt ++;
            }

        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(even_cnt + " " + odd_cnt);

    }

}
