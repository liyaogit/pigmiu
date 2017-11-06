package com.design;

import com.design.state.GumballMachine;
import org.junit.Test;

/**
 * User: yli
 * Date: 2017/7/24
 * Time: 17:49
 */
public class StateTest {
    @Test
    public void testState(){
        GumballMachine gumballMachine = new GumballMachine(3);
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
    }
}
