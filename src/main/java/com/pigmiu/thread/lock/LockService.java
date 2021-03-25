package com.pigmiu.thread.lock;

import com.pigmiu.thread.base.ThreadService;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockService implements ThreadService{
    public ReentrantLock lock = new ReentrantLock(true);  //公平锁，先启动的线程可以先获得锁。默认非公平锁
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();  //可实现通知部分线程

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(); //读写锁:读读共享，写写互斥，写读互斥

    public void testMethod(Object object) {
        try {
            lock.lock();
            System.out.println(" await开始时间为" + Thread.currentThread().getName() + System.currentTimeMillis());
            Thread.currentThread().sleep(2000);
            conditionA.await();
            //conditionA.awaitUninterruptibly();  线程等待被中断时不发生异常
            //conditionA.awaitUntil(new Date());  线程到时间唤醒自己
            System.out.println(" await结束时间为" + Thread.currentThread().getName() + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalA(){
        lock.lock();
        System.out.println(lock.hasWaiters(conditionA));  //是否有线程在等待与此锁相关的condition条件
        System.out.println("是否有线程在等待condition? :" + lock.hasWaiters(conditionA) + "。 数目是" + lock.getWaitQueueLength(conditionA));  //返回与此锁定相关的给定条件condition的线程等待数
        System.out.println(" signal时间为"+ Thread.currentThread().getName() + System.currentTimeMillis());
        conditionA.signal();
        lock.unlock();
    }

    public void serviceMethod(){
        System.out.println(lock.isFair());    //是否公平锁
        System.out.println(lock.isLocked());      //查询此lock是否由任意线程保持
        System.out.println(lock.isHeldByCurrentThread());   //查询当前线程是否保持此lock
        lock.lock();
        System.out.println(lock.isLocked());
        System.out.println(lock.isHeldByCurrentThread());
        System.out.println("测试ReentrantLock小方法 getHoldCount = " + lock.getHoldCount());  //查询当前线程调用lock方法的次数
        //lock.lockInterruptibly();  先判断当前线程是否中断，是则抛异常
        //lock.tryLock(); lock(时间内)未被其他线程保持情况下，获得锁。 可增加时间参数。(返回布尔类型，可异步增加相关处理）
        lock.lock();
        System.out.println("测试ReentrantLock小方法 getHoldCount = " + lock.getHoldCount());
        lock.unlock();
        lock.unlock();
    }

    public void read(){
        try {
            readWriteLock.readLock().lock();
            System.out.println("获得读锁" + Thread.currentThread().getName() + System.currentTimeMillis());
            Thread.sleep(100000);
            readWriteLock.readLock().unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write(){
        try {
            readWriteLock.writeLock().lock();
            System.out.println("获得读锁" + Thread.currentThread().getName() + System.currentTimeMillis());
            Thread.sleep(100000);
            readWriteLock.writeLock().unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
