package com.design.Decorator;

/**
 * Created by yli on 2017/5/4.
 */
public class HouseBlend extends Beverage{
    public HouseBlend() {
        description = "HouseBlend 综合咖啡";
    }

    public double cost() {
        return 10;
    }
}
