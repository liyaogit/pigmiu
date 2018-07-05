package com.design.composite;

import java.util.Iterator;

/**
 * User: yli
 * Date: 2017/7/17
 * Time: 16:12
 */
public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu(){
        Iterator iterator = allMenus.createIterator();
        System.out.println("\n全部菜单");
        while (iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();

                    menuComponent.print();

            }

    }

    public void printVegetarianMenu(){
        Iterator iterator = allMenus.createIterator();
        System.out.println("\n清真菜单");
        while (iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            try {
                if(menuComponent.isVegetarian()){
                    menuComponent.print();
                }
            }catch (UnsupportedOperationException e){};
        }
    }

}
