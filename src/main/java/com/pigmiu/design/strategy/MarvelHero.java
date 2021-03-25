package com.pigmiu.design.strategy;

/**
 * Created by yli on 2017/4/28.
 * 策略模式
 * 抽象漫威英雄类
 */
public abstract class MarvelHero {
    //接口声明，声明两个引用变量
    //行走方式
    MoveBehavior moveBehavior;
    //飞行方式
    FlyBehavior flyBehavior;

    //委托给接workBehavior，performFly处理
    public void performWork(){
        moveBehavior.move();
    }
    public void performFly(){
        flyBehavior.fly();
    }
    public abstract void display();

    public void from(){
        System.out.println("来自漫威漫画");
    }

    public void setMoveBehavior(MoveBehavior mb){
        moveBehavior = mb;
    }

    public  void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }
}
