package com.design.iterator;

import java.util.Iterator;

/**
 * User: yli
 * Date: 2017/7/14
 * Time: 17:21
 */
public class Waitress {
    Menu lunchMenu;
    Menu dinerMenu;
    Menu cafeMenu;

    public Waitress(Menu dinerMenu, Menu lunchMenu,  Menu cafeMenu) {
        this.dinerMenu = dinerMenu;
        this.lunchMenu = lunchMenu;
        this.cafeMenu = cafeMenu;
    }

    public void printMenus(){
        Iterator dinerIterator =  dinerMenu.createIterator();
        Iterator lunchIterator = lunchMenu.createIterator();
        Iterator cafeIterator = cafeMenu.createIterator();
        System.out.println("午饭");
        printMenu(lunchIterator);
        System.out.println("西餐");
        printMenu(dinerIterator);
        System.out.println("咖啡");
        printMenu(cafeIterator);
    }

    private void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem)iterator.next();
            System.out.println(menuItem.getName()+","+menuItem.getPrice()+"--"+menuItem.getDescription());
        }
    }
}
