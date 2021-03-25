package com.base;

import org.junit.Test;

/**
 * @author nuosong
 * @version : iterateTest.java, v 0.1 2020年09月15日 11:53 AM nuosong Exp $
 */

public class iterateTest {

    @Test
    public void testDoWhile(){
        int i = 0; boolean success = false;
        do {
            if (i == 1){
                continue;
            }
            System.out.println(i);
            success = true;
        }while (++i < 3 && !success);

        System.out.println("retry:" + i);

    }
}
