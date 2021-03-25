package com.pigmiu.tips;

import com.google.common.collect.Lists;
import com.pigmiu.variety.dto.Animal;
import com.pigmiu.variety.dto.Dog;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @description: java8特性
 * @author: nuosong
 * @create: 2020-06-11 20:48
 **/

public class StreamTest {

    @Test
    public void testMax(){
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        Optional optional = list.stream().min(Integer::compareTo);
        if (optional.isPresent()){
            System.out.println(optional.get());
        }
    }


    @Test
    public void testSort(){
        List<Animal> animalList = new ArrayList<>();
        Animal d1 = new Dog();
        d1.setAge(12);
        d1.setName("max");

        Animal d2 = new Dog();
        d2.setAge(1);
        d2.setName("min");
        animalList.add(d1);
        animalList.add(d2);

        Optional optional = animalList.stream().min(Comparator.comparingInt(Animal::getAge)).map(Animal::getAge);

        if (optional.isPresent()){
            Integer age = (Integer) optional.get();
            System.out.println(age);
        }


    }

}
