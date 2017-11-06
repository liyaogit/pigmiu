package com.design.iterator;

import java.util.HashMap;
import java.util.Iterator;

/**
 * User: yli
 * Date: 2017/7/17
 * Time: 11:27
 */
public class CafeMenu implements Menu {
    HashMap menuItems = new HashMap();

    public CafeMenu() {
        addItem("拿铁","特别棒",true,20);
        addItem("鸡肉沙拉","小鲜鸡肉",true,22.0);
    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(),menuItem);
    }

    public Iterator createIterator() {
        return menuItems.values().iterator();
    }
}
