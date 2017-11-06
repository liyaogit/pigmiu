package com.design;

import com.design.decorator.*;
import org.junit.Test;

/**
 * Created by yli on 2017/5/10.
 */
public class DecoratorTest {
    @Test
    public void Starbuck(){
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+":人民币"+beverage.cost()+"元");

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(new Mocha(beverage1));
        beverage1 = new Soy(beverage1);
        System.out.println(beverage1.getDescription()+":人民币"+beverage1.cost()+"元");

        Beverage beverage2 = new Decat();
        beverage2 = new Soy(beverage2);
        beverage2 = new Whip(beverage2);
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDescription()+":人民币"+beverage2.cost()+"元");
    }
}
