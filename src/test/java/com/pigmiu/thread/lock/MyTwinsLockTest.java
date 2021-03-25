package com.pigmiu.thread.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @Auther: yli
 * @Date: 2018/7/18 15:37
 * @Description:线程名称成对输出
 */
public class MyTwinsLockTest {
    @Test
    public void test(){
        final Lock lock = new MyTwinsLock();
        class Worker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++ ){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }
        //for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(10000);
                //System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
         //   }
        }
    }
}
