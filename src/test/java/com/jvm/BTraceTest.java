package com.jvm;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: yli
 * @Date: 2018/10/24 17:32
 * @Description:
 */
public class BTraceTest {
    private static int add(int a, int b){
        return a + b;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 100; i ++){
            Thread.sleep(5000);
            int a = (int) (Math.random() * 1000);
            int b = (int) (Math.random() * 1000);
            System.out.println(add(a, b));
        }
    }
}
