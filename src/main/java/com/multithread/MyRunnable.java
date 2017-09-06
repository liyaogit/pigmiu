package com.multithread;

/**
 * User: yli
 * Date: 2017/8/30
 * Time: 16:46
 * 1.丢失更新
 * 2.账户透支
 */
public class MyRunnable implements Runnable{
    private int count;
    public void run() {
        for (int i = 0; i < 25; i++){
            String name = Thread.currentThread().getName();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){  //加锁同步方法块
                increment();
                System.out.println(name + count);
            }

        }
    }

    private void increment(){
        int i = count;
        count = i + 1;
    }
}
