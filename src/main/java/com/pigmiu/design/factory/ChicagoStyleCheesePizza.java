package com.pigmiu.design.factory;

/**
 * User: yli
 * Date: 2017/6/5
 * Time: 16:18
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "芝加哥风味深盘比萨";
        dough = "厚饼";
        sauce = "小番茄酱(Plum Tomato sauce)";

        toppings.add("意大利白干酪");
    }

    @Override
    void cut(){
        System.out.println("pizza切正方形");
    }
}
