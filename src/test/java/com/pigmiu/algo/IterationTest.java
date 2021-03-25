package com.pigmiu.algo;

import org.junit.Test;

import java.util.ArrayList;

import static com.pigmiu.algo.recursion.Iteration.recursion;

/**
 * @Auther: yli
 * @Date: 2018/12/28 10:11
 * @Description:
 */
public class IterationTest {

    @Test
    public void testRecursion(){
        long total = 128;

        recursion(total, new ArrayList<Long>());
    }


}
