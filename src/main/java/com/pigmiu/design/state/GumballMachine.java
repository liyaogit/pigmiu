package com.pigmiu.design.state;

/**
 * User: yli
 * Date: 2017/7/18
 * Time: 17:53
 */
public class GumballMachine {
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State soldOutState;
    State winnerState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int number) {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        soldOutState = new SoldOutState(this);
        count = number;
        if (number > 0){
            state = noQuarterState;
        }
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall(){
        System.out.println("奖品已经发放");
        count--;
    }

    public void refill(int number){
        count = number;
        state = noQuarterState;
    }

    public State getState() {
        return state;
    }

    void setState(State state) {
        this.state = state;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("库存数量").append(count).append("\n").append("当前状态").append(state.getClass().getName());
        return sb.toString();
    }
}
