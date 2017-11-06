package com.pigmiu.tool.collection;

import com.pigmiu.dto.Animal;

import java.util.Comparator;

/**
 * User: yli
 * Date: 2017/9/1
 * Time: 11:39
 * 比较另一种做法,不同字段实现多种比较器
 */
public class AnimalAgeComparator implements Comparator<Animal> {
    public int compare(Animal o1, Animal o2) {
        return  o1.getAge()-o2.getAge();
    }
}
