package com.thread.base;

public class ThreadC extends Thread{
    private Object object;
    private ThreadService service;

    public ThreadC(Object object, ThreadService service) {
        this.object = object;
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + "运行了");
        service.testMethod(object);
    }
}
