package com.thread.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Auther: yli
 * @Date: 2018/8/9 11:25
 * @Description:
 */
public class ForkJoinCountTask extends RecursiveTask<Integer>{

    private static final int THRESHOLD =2; //阈值
    private int start;
    private int end;

    public ForkJoinCountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果认为足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute){
            for (int i = start; i <= end; i++){
                sum += i;
            }
        } else {
            //如果任务大于阈值,就分裂成两个子任务
            int middle = (start + end) / 2;
            ForkJoinCountTask left = new ForkJoinCountTask(start, middle);
            ForkJoinCountTask right = new ForkJoinCountTask(middle + 1, end);
            //执行子任务
            left.fork();
            right.fork();
            //等待子任务执行完结果
            int leftResult = left.join();
            int rightResult = right.join();
            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务, 1+2+3+4
        ForkJoinCountTask task = new ForkJoinCountTask(1, 4);
        //执行这个任务
        Future<Integer> result = forkJoinPool.submit(task);

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
