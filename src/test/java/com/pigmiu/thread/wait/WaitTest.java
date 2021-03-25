package com.pigmiu.thread.wait;

import com.pigmiu.thread.base.ThreadA;
import com.pigmiu.thread.base.ThreadB;
import com.pigmiu.thread.base.ThreadC;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException{
        Object lock = new Object();
        WaitService service = new WaitService();
        ThreadA a = new ThreadA(lock, service);
        a.start();
        ThreadB b = new ThreadB(lock, service);
        b.start();
        ThreadC c = new ThreadC(lock, service);
        c.start();
        Thread.sleep(1000);
        service.testNotify(lock);   //注意唤醒和wait的顺序不能颠倒
    }
}
