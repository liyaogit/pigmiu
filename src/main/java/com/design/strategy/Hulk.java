package com.design.strategy;

/**
 * Created by yli on 2017/4/28.
 */
public class Hulk extends MarvelHero{
    public Hulk(){
        this.flyBehavior=new FlyWithSuperpowers();
        this.moveBehavior=new MoveWithRunning();
    }
    @Override
    public void display(){
        System.out.println("我是绿巨人");
    }
}
