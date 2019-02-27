package com.jvm.gc;

/**
 * @Auther: yli
 * @Date: 2018/9/3 10:04
 * -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * @Description: -XX:MaxTenuringThreshold=1 设置对象进入老年代的年龄
 * 动态对象年龄判断：survivor中相同年龄所有对象大小>survivor空间一半,年龄>=该年龄的对象就可以直接进入老年代。
 */
public class TenuringThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args){
        byte[] a1, a2, a3;
        a1 = new byte[_1MB / 4];
        a2 = new byte[4 * _1MB];
        a3 = new byte[4 * _1MB];
        a3 = null;
        a3 = new byte[4 * _1MB];  //触发第二次GC
    }

}
