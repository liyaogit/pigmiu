package com.design.singleton;

public class Singleton2 {
    private static Singleton2 object;
    private Singleton2() {
    }

    public static Singleton2 getInstance(){
        //懒汉模式,延迟加载，线程不安全
        if (object == null){
            object = new Singleton2();
        }
        return object;
    }
}
