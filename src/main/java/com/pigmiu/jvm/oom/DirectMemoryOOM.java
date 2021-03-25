package com.pigmiu.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Auther: yli
 * @Date: 2018/8/29 17:05
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M 若不指定MaxDirectMemorySize,默认与(-Xmx)一样
 * @Description:怎么不报oom啊！
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024 * 3;
    public static void main(String[] args) throws Exception{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
