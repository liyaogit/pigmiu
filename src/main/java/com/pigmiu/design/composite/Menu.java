package com.pigmiu.design.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * User: yli
 * Date: 2017/7/17
 * Time: 14:21
 */
public class Menu extends MenuComponent {
    ArrayList menuComponents = new ArrayList();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.print("," + getDescription());
        System.out.print("------------------");

//        Iterator iterator = menuComponents.iterator();
//        while (iterator.hasNext()){
//            MenuComponent menuComponent = (MenuComponent)iterator.next();
//            menuComponent.print();
//        }
    }

    @Override
    public Iterator createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }
}
