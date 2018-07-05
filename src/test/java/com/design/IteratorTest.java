package com.design;

import com.design.iterator.*;
import org.junit.Test;

/**
 * User: yli
 * Date: 2017/7/14
 * Time: 17:46
 */
public class IteratorTest {
    @Test
    public void testWaitress(){
        Menu dinerMenu = new DinerMenu();
        Menu lunchMenu = new LunchMenu();
        Menu cafeMenu = new CafeMenu();
        Waitress waitress = new Waitress(dinerMenu,lunchMenu,cafeMenu);
        waitress.printMenus();
    }
}
