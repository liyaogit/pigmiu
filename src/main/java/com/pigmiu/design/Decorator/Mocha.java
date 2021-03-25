package com.pigmiu.design.decorator;

/**
 * Created by yli on 2017/5/10.
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription()+",摩卡";
    }

    public double cost() {
        return 3 + beverage.cost();
    }
}
