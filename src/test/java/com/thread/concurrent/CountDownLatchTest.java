package com.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: yli
 * @Date: 2018/12/6 16:56
 * @Description: CountDownLatch允许一个或者多个线程等待其他线程
 */
public class CountDownLatchTest {
    //可以用在任何地方，可以是2个线程，也可是是一个线程里的2个步骤
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        //等待,为0时唤醒
        c.await();
        System.out.println(3);

    }

}
