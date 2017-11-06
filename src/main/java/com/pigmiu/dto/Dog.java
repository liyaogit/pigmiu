package com.pigmiu.dto;

/**
 * User: yli
 * Date: 2017/9/1
 * Time: 16:28
 */
public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog(String name, int age, Boolean food) {
        super(name, age);
        this.setFood(food);
    }
}
