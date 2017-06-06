package com.design.Decorator;

/**
 * Created by yli on 2017/5/10.
 */
public class Soy extends CondimentDecorator{
    Beverage beverage;
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription()+",豆浆";
    }

    public double cost() {
        return 2 + beverage.cost();
    }
}
