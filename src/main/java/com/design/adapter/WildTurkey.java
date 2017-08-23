package com.design.adapter;

/**
 * User: yli
 * Date: 2017/6/15
 * Time: 15:35
 */
public class WildTurkey implements Turkey {
    public void gobble() {
        System.out.println("咯咯咯");
    }

    public void fly() {
        System.out.println("窝草不太能飞动");
    }
}
