package com.pigmiu.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yli
 * @Date: 2018/10/24 10:47
 * @Description:
 */
public class JConsoleTest {
    static class OOMObject{
        private byte[] holder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i ++){
            Thread.sleep(500);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args)throws Exception{
        fillHeap(1000);
    }
}

