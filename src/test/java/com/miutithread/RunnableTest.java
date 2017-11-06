package com.miutithread;

import com.multithread.MyRunnable;

/**
 * User: yli
 * Date: 2017/8/30
 * Time: 16:48
 */
public class RunnableTest {

    public static void main(String[] args){
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread.setName("yli");
        thread2.setName("le");
        thread.start();
        thread2.start();
    }
}
