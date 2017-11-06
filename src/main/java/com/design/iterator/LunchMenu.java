package com.design.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * User: yli
 * Date: 2017/7/14
 * Time: 16:13
 */
public class LunchMenu implements Menu{
    ArrayList menuItems;

    public LunchMenu() {
        menuItems = new ArrayList();
        addItem("烧鸡","鲜嫩多汁",false,20.0);
        addItem("土豆丝","初恋的味道",true,9.9);
    }

    private void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    @Deprecated
    public ArrayList getMenuItems() {
        return menuItems;
    }

    public Iterator createIterator(){
        return menuItems.iterator();
    }
}
