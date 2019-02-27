package com.thread.wait;

import com.thread.base.ThreadService;

public class WaitService implements ThreadService{

    public void testNotify(Object object) {

        synchronized (object) {
            System.out.println("notify 开始。 线程:" + Thread.currentThread().getName());
            //notify 方法只可以在synchronized同步块里使用
            //object.notify();
            object.notifyAll(); //唤醒全部wait线程，notify唤醒随机一个
            System.out.println("notify 结束。 线程:" + Thread.currentThread().getName());
        }

    }


    public void testMethod(Object object) {
        try {
            synchronized (object) {
                System.out.println("wait 开始。 线程:" + Thread.currentThread().getName());
                //wait 方法只可以在synchronized同步块里使用
                object.wait();
                //带时间参数，超过时间自动唤醒
                object.wait(5000);
                System.out.println("wait 结束。 线程:" + Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
