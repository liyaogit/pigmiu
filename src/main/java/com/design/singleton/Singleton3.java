package com.design.singleton;

public class Singleton3 {
    private volatile static Singleton3 object;  //支持静态和实例字段
    private String a;
    private Singleton3() {
    }

    //双重检测 Double-check locking 线程安全
    public static Singleton3 getInstance() {
        try {
            if (null == object) {
                //模拟创建对象前的一些准备工作
                Thread.sleep(3000);
                synchronized (Singleton3.class){
                    if (null == object){
                        object = new Singleton3();   //1、分配对象内存。2对象初始化。3、object指向内存
                                                     // 一定是volatile类型，否则2和3可能发生重排序。
                    }
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return object;
    }
}
