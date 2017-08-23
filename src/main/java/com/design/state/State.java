package com.design.state;

/**
 * User: yli
 * Date: 2017/7/18
 * Time: 17:39
 */
public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
