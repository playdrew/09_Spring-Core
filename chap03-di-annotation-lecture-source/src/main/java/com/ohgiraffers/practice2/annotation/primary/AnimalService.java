package com.ohgiraffers.practice2.annotation.primary;

import com.ohgiraffers.practice2.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("primaryService")
public class AnimalService {

    private Animal animal;

    @Autowired
    public AnimalService(Animal animal){
        this.animal=animal;
    }

    public void animalMethod(){
        animal.eat();
    }

}
