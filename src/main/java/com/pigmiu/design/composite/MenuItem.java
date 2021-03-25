package com.pigmiu.design.composite;

import java.util.Iterator;

/**
 * User: yli
 * Date: 2017/7/17
 * Time: 14:14
 */
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
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
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.print("  "+getName());
        if(isVegetarian()){
            System.out.print("(V)");
        }
        System.out.print(","+getPrice());
        System.out.print("    --"+getDescription());
    }

    @Override
    public Iterator createIterator() {
        return new NullIterator();
    }
}
