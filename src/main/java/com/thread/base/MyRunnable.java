package com.thread.base;

/**
 * User: yli
 * Date: 2017/8/30
 * Time: 16:46
 * 1.丢失更新
 * 2.账户透支
 * 非线程安全:是指多个线程对同一个对象中的同一个实例变量进行操作时会出现值被更改、不同步的情况。
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
            synchronized (this){  //加锁同步方法块，否则如果共享变量线程不安全
                increment();
                System.out.println(name + "线程计算,count = " + count);
            }

        }
    }

    private void increment(){
        int i = count;
        count = i + 1;
    }

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
    }
}
