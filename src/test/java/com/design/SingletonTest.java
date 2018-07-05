package com.design;

import com.design.singleton.Singleton6;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void testSingleton (){
        System.out.println(Singleton6.getObject());
        System.out.println(Singleton6.getObject());
        System.out.println(Singleton6.getObject());
    }
}
