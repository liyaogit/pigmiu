package com.thread.base;

import com.thread.base.MyRunnable;
import org.junit.Test;

/**
 * User: yli
 * Date: 2017/8/30
 * Time: 16:48
 */
public class RunnableTest {

    public static void main(String[] args){
        Runnable runnable = new MyRunnable();
        Runnable runnable2 = new MyRunnable();
        Thread thread = new Thread(runnable);     //传入同一个runnable实例,多线程共享变量,否则实例变量不共享
        Thread thread2 = new Thread(runnable);
        thread.setName("A");
        thread2.setName("B");
        thread.start();
        thread2.start();
    }

    @Test
    public void testRunable(){
        Runnable runnable = new MyRunnable();
        Runnable runnable2 = new MyRunnable();
        Thread thread = new Thread(runnable);     //传入同一个runnable实例,多线程共享变量,否则实例变量不共享
        Thread thread2 = new Thread(runnable2);
        thread.setName("A");
        thread2.setName("B");
        thread.start();
        thread2.start();

        try {
            Thread.sleep(5000);   //因junit运行完即终止所有线程，sleep以完成测试
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
