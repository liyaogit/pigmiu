package com.pigmiu.thread.base;

public class ThreadSleep extends Thread{

    @Override
    public void run(){
        try {
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run begin");
        } catch (InterruptedException e) {    //沉睡中停止，停止再沉睡 都会进入该异常
            System.out.println("都不知道发生了啥");
            e.printStackTrace();
        }
    }

}
