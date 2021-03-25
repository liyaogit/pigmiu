package com.pigmiu.design.state;

/**
 * User: yli
 * Date: 2017/7/18
 * Time: 17:47
 */
public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("你已经投过了");
    }

    public void ejectQuarter() {
        System.out.println("你已经选择出货了");
    }

    public void turnCrank() {
        System.out.println("两次了");
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.count > 0){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }else {
            System.out.println("售罄了");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
