package com.thread.base;

import org.junit.Test;

public class ThreadTest {

    @Test
    public void testMyThread() throws InterruptedException {
        Thread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(myThread);  //将线程对象以构造参数的方式传递给Thread对象
        thread.start();  //start方法不能多次调用
        Thread.sleep(5000);
        System.out.println("结束");  //有时会后执行run方法
    }

    @Test
    public void testGetId(){
        Thread thread = Thread.currentThread();
        //打印线程Id
        System.out.println("线程name" + thread.getName() + "  id:" + thread.getId());
    }




}
