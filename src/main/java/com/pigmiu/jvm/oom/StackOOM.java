package com.pigmiu.jvm.oom;

/**
 * @Auther: yli
 * @Date: 2018/8/29 13:56
 * VM Args: -Xss2m (堆内存和栈容量设置大些,更容易造成栈内存溢出)
 * @Description:32位虚拟机
 */
public class StackOOM {

    private void forever(){
        while (true){
        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    forever();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args){
        StackOOM oom = new StackOOM();
        oom.stackLeakByThread();
    }
}
