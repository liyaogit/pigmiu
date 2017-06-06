package com.design.factory;

/**
 * User: yli
 * Date: 2017/6/5
 * Time: 16:14
 */
public class NYStyleCheesePizza extends Pizza{
    public NYStyleCheesePizza() {
        name = "纽约风味芝士比萨";
        dough = "博饼";
        sauce = "番茄酱(marinara sauce)";

        toppings.add("意大利reggiano高级干酪");
    }
}
