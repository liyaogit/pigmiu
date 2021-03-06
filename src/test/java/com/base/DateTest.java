package com.base;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

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
        System.out.println("Day of year:" + calendar.get(Calendar.DAY_OF_YEAR));

        Calendar begin = calendar;

        begin.add(Calendar.DAY_OF_YEAR, 4);
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("day of year:" + calendar.get(Calendar.DAY_OF_YEAR));

        //calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.DAY_OF_YEAR, 25);

        Date date = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date date1 = calendar.getTime();


        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));



    }

    @Test
    public void transform(){
        Set<String> set;
        Date date = new Date();
        Object o = date.getTime();
        Date newDate = new Date(Long.valueOf(o.toString()));
        System.out.println(date.getTime());
        System.out.println(""+null);
    }

    @Test
    public void getDateRange(){
        String date = "06分20秒";
        String[] d = date.split("分|秒");

        int ll = Integer.valueOf(d[0]) * 60 + Integer.valueOf(d[1]);

        System.out.println(ll);

    }
}
