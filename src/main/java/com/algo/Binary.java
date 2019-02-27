package com.algo;

import java.math.BigInteger;

/**
 * @Auther: yli
 * @Date: 2018/12/18 11:47
 * @Description:二进制运算,位运算
 */
public class Binary {

    /**
     * @Description:十进制转换成二进制
     */
    public static String decimalToBinary(int decimal){
        BigInteger bigInteger = new BigInteger(String.valueOf(decimal));  //转成bigInteger类型,默认10进制
        return bigInteger.toString(2);   //转化2进制
    }

    /**
     * @Description:二进制转十进制
     */
    public static int binaryToDecimal(String binary){
        BigInteger bigInteger = new BigInteger(binary, 2);  //转成bigInteger类型,参数2进制
        return Integer.valueOf(bigInteger.toString());   //默认转化10进制
    }


    /**
     * @Description: 向左移位
     * @param num 等待移位的十进制数, m 向左移的位数
     * @return int 移位后的十进制数
     */
    public static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * @Description: 向右移位
     * @param num 等待移位的十进制数, m 向右移的位数
     * @return int 移位后的十进制数
     */
    public static int rightShift(int num, int m) {
        return num >>> m;
    }


}
