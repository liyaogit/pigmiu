package com.design.decorator;

/**装饰者模式
 * 应用场景: Java I/O
 * 饮料超类
 * Created by yli on 2017/5/4.
 */
public abstract class Beverage {
    String description = "不知道啥饮料";

    public String getDescription(){
        return this.description;
    }

    public abstract double cost();
}
