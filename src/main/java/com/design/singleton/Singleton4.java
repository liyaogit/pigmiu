package com.design.singleton;

public class Singleton4 {
    //内部类方式
    private static class SingletonHandler{
        private static Singleton4 object = new Singleton4();  //仅支持静态字段
    }
    private Singleton4() {
    }

    public static Singleton4 getInstance(){
        return SingletonHandler.object;   //导致类被初始化，多线程初始化同一个类是同步的
    }
}
