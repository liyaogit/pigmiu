package com.base;

import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yli on 2017/3/15.
 */
public class BaseTest {
    @Test
    //String不可传递
    public void testBase(){
        long i = 64;
        int j = (int)i;
        System.out.println(j);

        String l = "6";
        getString(l);
        System.out.println(l);
    }

    private void getString(String s){
        s = "1";
    }

    @Test
    public void testMiu(){
        String b = "blue";
        b.replace('b','j');
        Map<String, String > hh = new HashMap<String, String>();
        hh.put("1","11");
        boolean j = "".equals(null);
        System.out.println(j);
        System.out.println(b);

        String ha = "haha";
        String x = ha;
        ha = "jiji";
        System.out.println(x);
        Integer s = 1;
        Assert.assertTrue(s.equals(1));
    }


    @Test
    public void testEqual(){
        String id = null;
        if(id ==null || id.equals("")){
            System.out.println(id);
        }
        byte i = 3;
        int j = 3;
        String[] list = new String[2];
        System.out.println(i==j);

        String a = "a";
        String b = "a";
        System.out.println(a==b);

    }

    @Test
    public void testBase64(){
       String code = "MXFhekBXU1g=500";
       String o = code.substring(0,code.length()-1);
       System.out.println(new String(Base64.decodeBase64(code.substring(0,code.length()-3))));
    }

    private static String decodeBase64(String code){
        return new String(Base64.decodeBase64(code));
    }

    @Test
    public void testTransform(){
        Integer v = 10100;
        Integer v3 = 600;

        System.out.println(formatFromF2Y(v));
        System.out.println(formatFromF2Y(v3));
    }

    public static String formatFromF2Y(Integer value){
        final DecimalFormat FORMAT=new DecimalFormat("0.##");
        if(value==null)
            return "";
        if(Integer.MAX_VALUE==value.intValue())
            return "";
        if(value==0)
            return "0";
        try {

            BigDecimal ret=new BigDecimal(value).divide(new BigDecimal(100));
            return FORMAT.format(ret);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void cal(){
        Integer rate = 6;

        Float fee = (float)  6 /(float)1000 * 1600;

        System.out.print(fee);

    }

    @Test
    public void uuid(){

        System.out.print(UUID.randomUUID());

    }

    @Test
    public void div(){
        int total = 129;
        Integer d = 8;

        double rate =   (double) d /(double) total;
        String result = String.format("%.1f", rate);
        System.out.print(result);

    }
}










