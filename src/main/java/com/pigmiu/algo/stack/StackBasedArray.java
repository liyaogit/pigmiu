package com.pigmiu.algo.stack;

import java.util.Scanner;

/**
 * @Auther: yli
 * @Date: 2019/1/11 09:58
 * @Description:基于数组实现的栈
 */
public class StackBasedArray {
    private String[] items;
    private int capacity;       //栈的大小
    private int count;          //栈中元素个数

    //初始化数组,申请大小为capacity的数组空间
    public StackBasedArray(int capacity) {
        this.capacity = capacity;
        this.items = new String[capacity];
        this.count = 0;
    }

    //入栈操作
    public void push(String data){
        if (capacity == count){
            //数组扩容
            capacity = (int)(capacity*1.5);
            String[] tempItems = new String[capacity];
            for (int i = 0; i < count; i++){
                tempItems[i] = items[i];
            }
            items = tempItems;
            items[count] = data;
            ++count;
        }else {
            items[count] = data;
            ++count;
        }
    }

    //出栈操作
    public String pop(){
        if (count == 0) return null;
        String tmp = items[count-1];
        --count;
        return tmp;
    }


    public static void main(String[] args){
        StackBasedArray arrayStack = new StackBasedArray(5);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("4");
        arrayStack.push("4");

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}
