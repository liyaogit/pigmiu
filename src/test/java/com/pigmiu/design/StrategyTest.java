package com.pigmiu.design;

import com.pigmiu.design.strategy.Hulk;
import com.pigmiu.design.strategy.IronMan;
import com.pigmiu.design.strategy.MarvelHero;
import com.pigmiu.design.strategy.MoveWithBlink;
import org.junit.Test;

/**
 * Created by yli on 2017/4/28.
 * 策略模式
 */
public class StrategyTest {
    @Test
    public void testHulk(){
        MarvelHero hulk = new Hulk();
        hulk.display();
        hulk.from();
        hulk.performWork();
        hulk.performFly();
    }

    @Test
    public void testIronMan(){
        MarvelHero ironMan = new IronMan();
        ironMan.display();
        ironMan.from();
        ironMan.performWork();
        ironMan.performFly();
        ironMan.setMoveBehavior(new MoveWithBlink());
        ironMan.performWork();
    }
}
