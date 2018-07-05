package com.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomTest {
    @Test
    public void testRangeRandom(){
        for (int i = 0; i < 100; i ++){
            int random = (int)(Math.random()*9);
            System.out.print(random);
        }

    }
}
