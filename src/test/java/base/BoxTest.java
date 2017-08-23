package base;

import org.junit.Test;

/**
 * User: yli
 * Date: 2017/8/17
 * Time: 21:37
 */
public class BoxTest {
    Integer i;
    int j;
    public static void main (String[] args){
        BoxTest t = new BoxTest();
        t.go();
    }


    @Test
    public void formatTest(){
        String s = String.format("%d",42.25);
        System.out.println(s);
    }

    @Test
    public void go(){
//        j=i;
        System.out.println(i);
        System.out.println(j);
    }

}
