package com.thread.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Auther: yli
 * @Date: 2018/7/18 14:25
 * @Description:自定义同步组件
 * 同一时刻最多两个线程访问,超过两个线程则阻塞(共享式访问)
 */
public class MyTwinsLock implements Lock{
    private final Sync sync = new Sync(2);  //定义资源数
    //自定义同步器
    private static final class Sync extends AbstractQueuedSynchronizer{
        Sync(int count) {
            if (count <=0){
                throw new IllegalArgumentException("参数必须大于0");
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for (;;){
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount < 0 || compareAndSetState(current, newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (;;){
                int current = getState();
                int newCount = current + arg;
                //CAS原子性保障
                if (compareAndSetState(current, newCount)){
                    return true;
                }
            }
        }
    }
    @Override
    public void lock() {
        sync.acquireShared(1);

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
