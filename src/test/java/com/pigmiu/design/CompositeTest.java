package com.pigmiu.design;

import com.pigmiu.design.composite.Menu;
import com.pigmiu.design.composite.MenuComponent;
import com.pigmiu.design.composite.MenuItem;
import com.pigmiu.design.composite.Waitress;
import org.junit.Test;

/**
 * User: yli
 * Date: 2017/7/17
 * Time: 16:14
 */
public class CompositeTest {
    @Test
    public void MenuTest(){
        //菜单
        MenuComponent lunchMenu = new Menu("午餐菜单","中餐");
        MenuComponent dinnerMenu = new Menu("晚餐菜单","西餐");
        MenuComponent cafeMenu = new Menu("下午茶菜单","咖啡");
        MenuComponent dessertMenu = new Menu("点心菜单","甜点");

        MenuComponent allMenu = new Menu("全部菜单","MD组合模式");
        allMenu.add(lunchMenu);
        allMenu.add(dinnerMenu);
        allMenu.add(cafeMenu);

        //添加菜单项
        lunchMenu.add(new MenuItem("烧鸡","鲜嫩多汁",false,20.0));
        lunchMenu.add(new MenuItem("土豆丝","初恋的味道",true,9.9));

        dinnerMenu.add(new MenuItem("牛排","三分",false,80));
        dinnerMenu.add(new MenuItem("披萨","外焦里嫩",true,50.0));
        dinnerMenu.add(dessertMenu);
        //子菜单

        dessertMenu.add(new MenuItem("花生雪冰","太贵了",true,66));
        dessertMenu.add(new MenuItem("芒果雪冰","太贵了",true,76));

        cafeMenu.add(new MenuItem("拿铁","特别棒",true,20));
        cafeMenu.add(new MenuItem("鸡肉沙拉","小鲜鸡肉",true,22.0));

        Waitress waitress = new Waitress(allMenu);
        waitress.printMenu();

        waitress.printVegetarianMenu();
    }
}
