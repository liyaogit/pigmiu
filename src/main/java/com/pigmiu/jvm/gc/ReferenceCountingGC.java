package com.pigmiu.jvm.gc;

/**
 * @Auther: yli
 * @Date: 2018/8/30 11:30
 * VM args: -XX:+PrintGCDetails
 * @Description:objA和objB互相引用,会不会被GC
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    //唯一用处占内存,以便在GC日志确认是否被回收
    private byte[] size = new byte[2 * _1MB];

    public static void main(String[] args){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        //objA = null;
        //objB = null;

        System.gc();
    }
}
