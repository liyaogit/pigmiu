package com.thread.base;

public class MyThread extends Thread{

    public MyThread(){
        System.out.println("构造函数方法Thread(this).currentThread().getName():" + Thread.currentThread().getName() + "/" + Thread.currentThread().isAlive());
        System.out.println("构造函数this.getName():" + this.getName()+ "/" + this.isAlive());
    }

    @Override
    public void run() {
        System.out.println("myThread");
        System.out.println("run方法Thread.currentThread().getName():" + Thread.currentThread().getName() + "/" + Thread.currentThread().isAlive());
        System.out.println("run方法this.getName():" + this.getName()+ "/" + this.isAlive()+"\n");

    }
}
