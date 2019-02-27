package com.thread.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: yli
 * @Date: 2018/12/6 17:05
 * @Description:一组线程到达一个同步点时被阻塞,直到最后一个线程到达屏障时，所有线程才会继续
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException {


    }
}
