package com.design.factory;

/**
 * User: yli
 * Date: 2017/6/5
 * Time: 16:46
 */
public class ChicagoStylePizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new ChicagoStyleCheesePizza();
        }else{
            return null;
        }
    }
}
