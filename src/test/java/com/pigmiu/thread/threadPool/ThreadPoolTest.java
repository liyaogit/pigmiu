package com.pigmiu.thread.threadPool;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 线程池测试类
 * @author: nuosong
 * @create: 2019-12-24 15:33
 **/

public class ThreadPoolTest {

    private static final ExecutorService TESTER = Executors.newFixedThreadPool(10);


    @Test
    public void testFix() {
        for (int i = 0; i < 5; i++) {
            TESTER.execute(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    try {

                        System.out.println(Thread.currentThread().getName() + "--" + i1);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            Thread.sleep(1000 * 50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
