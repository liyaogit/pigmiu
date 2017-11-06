package com.design.template;

/**
 * User: yli
 * Date: 2017/7/11
 * Time: 15:21
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("泡茶");
    }

    @Override
    void addCondiments() {
        System.out.println("加片柠檬");
    }

    @Override
    boolean needCondiments() {
        return false;
    }
}
