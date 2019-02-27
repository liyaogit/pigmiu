package com.thread.stop;

import com.thread.base.ThreadSleep;
import org.junit.Test;

public class StopThreadTest {
    public static void main(String[] args){
        Thread threadForStop = new ThreadForStop();
        threadForStop.start();
        try {
            Thread.sleep(60);
            threadForStop.interrupt();  //打一个停止标记，不是真的停止线程
            //Thread.currentThread().interrupt();

            //interrupted :静态方法，测试当前线程是否中断，第一次调用清除中断状态
            //System.out.println("是否停止1?:" + Thread.interrupted());
            //System.out.println("是否停止2?:" + Thread.interrupted());

            //isInterrupted，测试Thread对象是否中断，不清除状态
            System.out.println("是否停止1?:" + threadForStop.isInterrupted());
            System.out.println("是否停止2?:" + threadForStop.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStopSleepThread(){
        Thread thread = new ThreadSleep();
        thread.start();
        try {
            Thread.sleep(200);
            thread.interrupt();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
