package com.ohgiraffers.practice2.annotation.collection;

import com.ohgiraffers.practice2.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("collectionService")
public class AnimalService {

    private List<Animal> animals;

    @Autowired
    public AnimalService(List<Animal> animals){
        this.animals=animals;
    }

    public void animalMethod() {
        for(Animal animal: animals){
            animal.eat();
        }
    }
}
