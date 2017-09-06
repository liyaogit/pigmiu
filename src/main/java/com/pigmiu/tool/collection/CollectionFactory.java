package com.pigmiu.tool.collection;

import com.pigmiu.dto.Animal;
import com.pigmiu.dto.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * User: yli
 * Date: 2017/9/1
 * Time: 16:22
 */
public class CollectionFactory {
    public static List<Dog> getAnimalList(){
        List<Dog> animalList = new ArrayList<Dog>();
        animalList.add(new Dog("ketty",3));
        animalList.add(new Dog("萨摩",6));
        animalList.add(new Dog("中华田园犬",4));
        return animalList;
    }

    public static Dog[] getAnimalArrays(){
        return new Dog[]{new Dog("ketty",3),new Dog("萨摩",6),new Dog("中华田园犬",4)};
    }
}
