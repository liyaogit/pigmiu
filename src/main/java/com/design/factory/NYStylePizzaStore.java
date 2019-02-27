package com.design.factory;

/**
 * User: yli
 * Date: 2017/6/5
 * Time: 16:40
 */
public class NYStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }else{
            return null;
        }
    }
}
