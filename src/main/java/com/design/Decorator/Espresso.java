package com.design.decorator;

/**饮料具体实现类
 * Created by yli on 2017/5/4.
 */
public class Espresso extends Beverage {
    String description = "浓缩咖啡";
    public Espresso() {
        description = "浓缩咖啡";
    }

    public double cost() {
        return 18.5;
    }
}
