package com.thread.lock;

import com.thread.base.ThreadA;
import com.thread.base.ThreadB;
import com.thread.base.ThreadC;
import com.thread.base.ThreadService;
import com.thread.wait.WaitService;
import org.junit.Test;

public class LockTest {
    public static void main(String[] args) throws InterruptedException{
        //测试使用Condition实现等待、通知和局部通知
        Object lock = new Object();
        LockService service = new LockService();
        ThreadA a = new ThreadA(lock, service);
        a.start();
        ThreadB b = new ThreadB(lock, service);
        b.start();
        Thread.sleep(1000);
        System.out.println(service.lock.hasQueuedThreads());    //是否有线程在等待此lock
        System.out.println(service.lock.hasQueuedThread(a));    //指定线程是否在等待此lock
        System.out.println(service.lock.hasQueuedThread(b));
        service.signalA();

        //测试公平锁与非公平锁
        ThreadC[] threadArray = new ThreadC[10];
        for (int i = 0; i < 10; i ++){
            threadArray[i] = new ThreadC(lock, service);
        }

        for (ThreadC threadC : threadArray){
            threadC.start();
        }
    }

    @Test
    public void testStopSleepThread(){
        LockService service = new LockService();
        service.serviceMethod();
        System.out.println("有线程数" + service.lock.getQueueLength() + "在等待获取锁");
    }
}
