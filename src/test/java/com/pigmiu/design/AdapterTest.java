package com.pigmiu.design;

import com.pigmiu.design.adapter.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: yli
 * Date: 2017/6/15
 * Time: 15:42
 * 适配器模式
 */
public class AdapterTest {

    @Test
    public void testSimpleAdapter(){
        MallardDuck mallardDuck =  new MallardDuck();
        System.out.println("绿头鸭");
        testDuck(mallardDuck);

        WildTurkey wildTurkey = new WildTurkey();
        System.out.println("\n野生火鸡");
        wildTurkey.gobble();
        wildTurkey.fly();

        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);
        System.out.println("\n适配成鸭子之后");
        testDuck(turkeyAdapter);
    }

    private void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }

    @Test
    public void testIteratorAdapter(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");

        Iterator iterator = list.iterator();
        System.out.println(iterator.hasNext());

        if(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        IteratorAdapter iteratorAdapter = new IteratorAdapter(iterator);
        System.out.println(iteratorAdapter.hasMoreElements());
        if(iteratorAdapter.hasMoreElements()){
            System.out.println(iteratorAdapter.nextElement());
        }

    }
}
