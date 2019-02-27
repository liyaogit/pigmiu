package com.pigmiu;

import com.pigmiu.dto.Animal;
import com.pigmiu.dto.Dog;
import com.pigmiu.tool.collection.AnimalAgeComparator;
import com.pigmiu.tool.collection.CollectionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: yli
 * Date: 2017/9/1
 * Time: 11:24
 */
public class CompareTest {

    @Test
    public void testCompareObject(){
        List<Dog> animalList = CollectionFactory.getAnimalList();

        System.out.println(animalList);

        List<Dog> animalList1 = null;
        Collections.sort(animalList);
        System.out.println(animalList);
    }

    @Test
    public void testComparator(){
        List<Dog> animalList =  CollectionFactory.getAnimalList();
        System.out.println(animalList);

        Collections.sort(animalList,new AnimalAgeComparator());
        //Collections.sort(animalList);
        System.out.println(animalList);
    }

}
