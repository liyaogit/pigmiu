package com.pigmiu.thread.base;

public class ThreadA extends Thread{
    private Object object;
    private ThreadService service;

    public ThreadA(Object object, ThreadService service) {
        this.object = object;
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod(object);
    }
}
