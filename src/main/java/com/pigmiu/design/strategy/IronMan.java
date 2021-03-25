package com.pigmiu.design.strategy;

/**
 * Created by yli on 2017/4/28.
 */
public class IronMan extends MarvelHero{
    public IronMan(){
        this.flyBehavior = new FlyWithTool();
        this.moveBehavior = new MoveWithRunning();
    }
    @Override
    public void display(){
        System.out.println("我是钢铁侠");
    }
}
