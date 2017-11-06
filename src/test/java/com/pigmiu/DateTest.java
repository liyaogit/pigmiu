package com.pigmiu;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yli on 2017/11/1.
 */
public class DateTest {
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    @Test
    public void testCompareDate(){
        String showTime = "2017-11-02 09:50";
        Date showTimeDate = StringToDate(showTime,YYYY_MM_DD_HH_MM);

        Date startTime = StringToDate("2017-11-02" + " " + "13:10", YYYY_MM_DD_HH_MM);
        Date endTime = StringToDate("2019-11-07" + " " + "22:10",YYYY_MM_DD_HH_MM);
        System.out.println(acceptDate(startTime, endTime, showTimeDate));
    }


    private Date StringToDate(String dateStr,String format){
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }
        return date;
    }

    public boolean acceptDate(Date startTime, Date endTime, Date showTime) {
        Calendar start = Calendar.getInstance();
        start.setTime(startTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        Calendar show = Calendar.getInstance();
        show.setTime(showTime);

        //判断是否在日期区间之内
        if(show.get(Calendar.YEAR) * 1000 + show.get(Calendar.DAY_OF_YEAR) < start.get(Calendar.YEAR) * 1000 + start.get(Calendar.DAY_OF_YEAR)){
            return false;
        } else if(show.get(Calendar.YEAR) * 1000 + show.get(Calendar.DAY_OF_YEAR) > end.get(Calendar.YEAR) * 1000 + end.get(Calendar.DAY_OF_YEAR)){
            return false;
            //判断是否在时间范围之内
        } else if(show.get(Calendar.HOUR_OF_DAY) * 60 + show.get(Calendar.MINUTE)  < start.get(Calendar.HOUR_OF_DAY) * 60 + start.get(Calendar.MINUTE)){
            return false;
        } else if(show.get(Calendar.HOUR_OF_DAY) * 60 + show.get(Calendar.MINUTE)  > end.get(Calendar.HOUR_OF_DAY) * 60 + end.get(Calendar.MINUTE)){
            return false;
        }
        return true;
    }
}
