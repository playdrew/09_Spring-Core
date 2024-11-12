package com.ohgiraffers.practice2.annotation.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.practice2");

        String[] beans = context.getBeanDefinitionNames();

        for(String bean : beans){
            System.out.println(bean);
        }

        AnimalService animalService = context.getBean("primaryService", AnimalService.class);
        animalService.animalMethod();
    }
}
