package com.pigmiu;

import com.pigmiu.dto.Animal;
import com.pigmiu.dto.Dog;
import com.pigmiu.tool.collection.CollectionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: yli
 * Date: 2017/9/1
 * Time: 16:20
 */
public class CollectionTest {

    @Test
    public void testArrayListAndArray(){
        List<Dog> dogList = CollectionFactory.getAnimalList();
        List<Dog> dogList1 = CollectionFactory.getAnimalList();
        dogList1.addAll(dogList);

        List<Animal> animalList1 = new ArrayList<Animal>();
        ArrayList<Animal> animalList2 = new ArrayList<Animal>();


        transform(dogList);
    }

    private <T extends Animal>void transform(List<T> animalList){
        //private void transform(List<? extends Animal> animalList)
        for (Animal animal : animalList){
            animal.eat();
        }
    }
}
