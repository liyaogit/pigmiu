package com.pigmiu.thread.stop;
/*
* 线程终止方法
* 1.正常退出，run方法执行结束
* 2.stop强行终止，产生不可预料的后果，不推荐
* 3.interrupt方法终止
*
* */

import java.util.Date;

public class ThreadForStop extends Thread{

    @Override
    public void run() {
        try {
        Date date = new Date();
        for (int i = 0; i <= 10000; i++){
            if(this.isInterrupted()){
                System.out.println("发现被标记停止，退出");
                //return 用return也可以,推荐使用异常流，方便可控
                throw new InterruptedException();

            }
            System.out.println("i= " + i);
        }
        System.out.println((new Date().getTime()-date.getTime()) + "ms");
        } catch (InterruptedException e) {
            System.out.println("捕获到终止的线程");
            e.printStackTrace();
        }
    }


}
