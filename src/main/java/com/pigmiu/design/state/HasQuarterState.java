package com.pigmiu.design.state;

import java.util.Random;

/**
 * User: yli
 * Date: 2017/7/18
 * Time: 17:45
 */
public class HasQuarterState implements State {
    GumballMachine gumballMachine;

    Random random = new Random();

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("你投的太多了");
    }

    public void ejectQuarter() {
        System.out.println("退你钱");
        gumballMachine.setState(gumballMachine.getNoQuarterState());

    }

    public void turnCrank() {
        System.out.println("豪！！");
        int winner = random.nextInt(4);
        if(winner==1 && gumballMachine.count > 1){
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    public void dispense() {
        System.out.println("貌似你没有权限吧//soldOut状态仅有哦");
    }
}
