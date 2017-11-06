package com.pigmiu.dto;

import java.io.Serializable;

/**
 * User: yli
 * Date: 2017/8/8
 * Time: 13:05
 */
public class Animal implements Comparable<Animal>, Serializable{
    private String name;
    transient private Integer age;  // transient表示不需要序列化
    private Boolean food;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //对象里实现姓名比较方法,若是多个维度比较,需要重写比较器实现类Comparator
    public int compareTo(Animal o) {
        return food.compareTo(o.isFood());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(name).append(",").append(age).append("]");
        return sb.toString();
    }

    public void eat(){
        System.out.println("吃东西");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }
}
