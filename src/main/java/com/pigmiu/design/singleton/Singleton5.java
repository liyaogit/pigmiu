package com.pigmiu.design.singleton;

public class Singleton5 {
    private static Singleton5 object = null;

    private Singleton5() {
    }

    //静态代码块
    static {
        object = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return object;
    }
}
