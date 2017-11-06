package com.design.decorator;

/**
 * Created by yli on 2017/5/10.
 */
public class Whip extends CondimentDecorator{
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription()+",奶泡";
    }

    public double cost() {
        return 4 + beverage.cost();
    }
}
