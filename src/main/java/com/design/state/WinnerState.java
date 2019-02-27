package com.design.state;

/**
 * User: yli
 * Date: 2017/7/25
 * Time: 15:42
 */
public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
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
        System.out.println("你中奖了！双倍掉率");
        gumballMachine.releaseBall();
        if(gumballMachine.count == 0){
            System.out.println("售罄了,少你一个,联系人工");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }else {
            gumballMachine.releaseBall();
            if (gumballMachine.count > 0){
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            }else {
                System.out.println("售罄了！");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }

    }
}
