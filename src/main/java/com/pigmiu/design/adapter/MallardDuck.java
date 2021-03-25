package com.pigmiu.design.adapter;

/**
 * @Auther: yli
 * @Date: 2019/2/27 13:59
 * @Description:
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("嘎嘎嘎");
    }

    @Override
    public void fly() {
        System.out.println("我要飞了啊");
    }
}
