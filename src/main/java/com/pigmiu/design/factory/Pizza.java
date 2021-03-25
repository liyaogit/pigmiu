package com.pigmiu.design.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * User: yli
 * Date: 2017/6/5
 * Time: 15:47
 */
public class Pizza {
    String name;
    String dough;
    String sauce;
    List toppings = new ArrayList();

    void prepare(){
        System.out.println("正在准备中:" + name);
        System.out.println("和面:" + dough);
        System.out.println("加入酱汁:" + sauce);
        System.out.println("加入佐料:");
        for(Object topping : toppings){
            System.out.println("  " + topping);
        }
    }

    void bake(){
        System.out.println("350°烤25分钟");
    }

    void cut(){
        System.out.println("pizza切角");
    }

    void  box(){
        System.out.println("pizza装盒");
    }

    public String getName() {
        return name;
    }
}
