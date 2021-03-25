package com.pigmiu.jvm.gc;

/**
 * @Auther: yli
 * @Date: 2018/8/31 16:02
 * VM args: -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * Serial收集器下,添加 -XX:PretenureSizeThreshold=3145728 a4大于3M直接进入老年代,此线程不触发GC
 *  @Description: 对象优先在Eden分配
 *  新生代9M:Eden + 1个survivor区
 */
public class Allocation {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args){
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[4 * _1MB]; //Serial收集器触发一次Minor GC。
                                 //Parallel收集器没有进行GC,直接放入老年代。
    }
}
