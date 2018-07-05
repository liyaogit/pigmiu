package com.design;

import com.design.template.Coffee;
import com.design.template.Tea;
import com.design.template.Transformer;
import org.junit.Test;

import java.util.Arrays;

/**
 * User: yli
 * Date: 2017/7/11
 * Time: 15:32
 */
public class TemplateTest {
    @Test
    public void testBeverage(){
        Tea tea = new Tea();
        tea.prepareRecipe();
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
    }

    @Test
    public void testComparable(){
        Transformer[] transformers = {
                new Transformer("大黄蜂",80),
                new Transformer("威震天",80),
                new Transformer("擎天柱",80)
        };

        display(transformers);

        Arrays.sort(transformers);

        display(transformers);
    }

    private static void display(Transformer[] transformers){
        for (Transformer transformer : transformers){
            System.out.println(transformer);
        }
    }
}
