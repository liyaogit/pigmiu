package com.thread.base;

public class ThreadB extends Thread{
    private Object object;
    private ThreadService service;

    public ThreadB(Object object, ThreadService service) {
        this.object = object;
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod(object);
    }
}
