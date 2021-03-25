package com.pigmiu.design;

import com.pigmiu.design.factory.ChicagoStylePizzaStore;
import com.pigmiu.design.factory.NYStylePizzaStore;
import com.pigmiu.design.factory.Pizza;
import com.pigmiu.design.factory.PizzaStore;
import org.junit.Test;

/**
 * User: yli
 * Date: 2017/6/5
 * Time: 16:49
 */
public class FactoryTest {
    @Test
    public void testSimpleFactory(){
        PizzaStore nyStore = new NYStylePizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("我点了个"+ pizza.getName()+"\n");

        PizzaStore chicagoStore = new ChicagoStylePizzaStore();
        pizza = chicagoStore.orderPizza("cheese");
        System.out.print("我又点了个"+ pizza.getName());
    }
}
