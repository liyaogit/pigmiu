package com.base;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * User: yli
 * Date: 2017/8/21
 * Time: 12:24
 */
public class DateTest {
    @Test
    public void formatDate(){
        Date date = new Date();
        String s = String.format("%tc",date);
        String d = String.format("%tA,%tB %td",date,date,date);
        String f = String.format("%tA,%<tB %<td",date);
        System.out.println(s);
        System.out.println(d);
        System.out.println(f);
    }

    @Test
    public void calendarTest(){
        Calendar calendar = Calendar.getInstance();
//        System.out.println(d);
//        System.out.println(f);
    }
}
