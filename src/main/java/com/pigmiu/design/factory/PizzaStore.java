package com.pigmiu.design.factory;

/**
 * User: yli
 * Date: 2017/6/5
 * Time: 15:46
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    abstract Pizza createPizza(String type);
}
