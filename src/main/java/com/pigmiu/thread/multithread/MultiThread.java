package com.pigmiu.thread.multithread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Auther: yli
 * @Date: 2018/7/5 14:06
 * @Description:
 */
public class MultiThread {
    public static void main(String[] args){
        //获取java的线程管理MXBeen
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos){
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
//         [4]Signal Dispatcher    分发处理发送给JVM信号的线程
//         [3]Finalizer            调用对象finalize方法的线程
//         [2]Reference Handler    清除Reference的线程
//         [1]main                 main线程,用户程序入口
        }
    }
}
