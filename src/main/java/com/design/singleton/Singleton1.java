package com.design.singleton;

public class Singleton1 {
    private Singleton1() {
    }

    private static Singleton1 object = new Singleton1();

    //饿汉模式,调用方法前实例已创建。立即加载，线程安全.
    //缺点是非延时加载，如果创建大量实例需考虑性能问题
    public static Singleton1 getInstance(){
        return object;
    }
}
