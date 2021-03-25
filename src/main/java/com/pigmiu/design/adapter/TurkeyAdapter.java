package com.pigmiu.design.adapter;

/**
 * User: yli
 * Date: 2017/6/15
 * Time: 15:38
 */
public class TurkeyAdapter implements Duck{
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        turkey.fly();
        turkey.fly();
    }
}
