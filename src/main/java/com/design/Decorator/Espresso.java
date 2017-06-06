package com.design.Decorator;

/**饮料具体实现类
 * Created by yli on 2017/5/4.
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "浓缩咖啡";
    }

    public double cost() {
        return 18.5;
    }
}
