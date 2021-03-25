package com.pigmiu.design.state;

/**
 * User: yli
 * Date: 2017/7/18
 * Time: 17:47
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("没货了看不到么");
    }

    public void ejectQuarter() {
        System.out.println("你这不是扯么");
    }

    public void turnCrank() {
        System.out.println("滚");
    }

    public void dispense() {
        System.out.println("滚");
    }
}
