package com.design;

import com.design.strategy.Hulk;
import com.design.strategy.IronMan;
import com.design.strategy.MarvelHero;
import com.design.strategy.MoveWithBlink;
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
