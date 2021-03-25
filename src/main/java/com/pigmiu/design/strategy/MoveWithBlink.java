package com.pigmiu.design.strategy;

/**
 * Created by yli on 2017/4/28.
 */
public class MoveWithBlink implements MoveBehavior{
    public void move() {
        System.out.println("我通过闪烁来移动");
    }
}
