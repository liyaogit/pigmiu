package com.jvm.oom;

/**
 * @Auther: yli
 * @Date: 2018/8/29 13:56
 * VM Args: -Xss256k
 * @Description:
 */
public class StackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args){
        StackSOF sof = new StackSOF();
        try {
            sof.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length" + sof.stackLength);
            throw e;
        }

    }
}
