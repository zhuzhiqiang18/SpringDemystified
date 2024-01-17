package org.zzq.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 动物园
 */
public class Zoo {
    private final List<Animal> animalList = new ArrayList<>();
    public Zoo(Dog dog,Cat cat){
        this.animalList.add(dog);
        this.animalList.add(cat);
    }

    public void play(){
        animalList.forEach(item->{
            System.out.println(item.say());
        });
    }


}
