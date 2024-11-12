package com.ohgiraffers.practice2.annotation.qualifier;

import com.ohgiraffers.practice2.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("qualifierService")
public class AnimalService {

    private final Animal animal;

    @Autowired
    public AnimalService(@Qualifier("Lion") Animal animal){
        this.animal=animal;
    }

    public void animalMethod(){
        animal.eat();
    }
}
