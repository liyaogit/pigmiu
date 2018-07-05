package com.design.state;

/**
 * User: yli
 * Date: 2017/7/18
 * Time: 17:43
 */
public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("你投了个硬币");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void ejectQuarter() {
        System.out.println("你这是空手套白狼啊");
    }

    public void turnCrank() {
        System.out.println("忘记投币了吧");
    }

    public void dispense() {
        System.out.println("先投币吧小伙子");
    }
}
