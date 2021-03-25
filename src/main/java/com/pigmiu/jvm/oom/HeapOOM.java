package com.pigmiu.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yli
 * @Date: 2018/8/29 11:50
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @Description:
 */
public class HeapOOM {
    static class OOMObject{
    }

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
