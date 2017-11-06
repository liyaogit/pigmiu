package com.design.template;

/**
 * User: yli
 * Date: 2017/7/11
 * Time: 15:00
 */
public abstract class CaffeineBeverage {
    //模板方法定义准备步骤
    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        //加入挂钩
        if (needCondiments()){
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    public void boilWater(){
        System.out.println("先烧个开水吧");
    }

    public void pourInCup(){
        System.out.println("饮料倒杯子里");
    }

    boolean needCondiments(){
        return true;
    }
}
