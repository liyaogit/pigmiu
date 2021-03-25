package com.pigmiu.design.decorator;

/**
 * Created by yli on 2017/5/10.
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description="深度烘焙咖啡";
    }

    public double cost() {
        return 14;
    }
}
