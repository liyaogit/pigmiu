package com.pigmiu.design.iterator;

import java.util.Iterator;

/**
 * User: yli
 * Date: 2017/7/14
 * Time: 16:10
 */
public class DinerMenu implements Menu{
    static final int MAX_ITEMS = 3;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("牛排","三分",false,80);
        addItem("披萨","外焦里嫩",true,50.0);
    }

    private void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS){
            System.err.println("菜单满了,没法添加了");
        }else {
            menuItems[numberOfItems] =  menuItem;
            numberOfItems ++;
        }
    }

    @Deprecated
    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
}
