package base;

import junit.framework.TestCase;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yli on 2017/3/15.
 */
public class BaseTest {
    @Test
    public void testBase(){
        long i = 64;
        int j = (int)i;
        System.out.println(j);
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
    }

    @Test
    public void testBase64(){
       String code = "MXFhekBXU1g=500";

        System.out.println(new String(Base64.decodeBase64(code.substring(0,code.length()-3))));
    }

    private static String decodeBase64(String code){
        return new String(Base64.decodeBase64(code));
    }
}










