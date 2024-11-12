package com.ohgiraffers.practice2.annotation.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.practice2");
        AnimalService animalService = context.getBean("collectionService",AnimalService.class);

        String[] beans = context.getBeanDefinitionNames();
        for(String bean : beans){
            System.out.println("bean = " + bean);
        }

        animalService.animalMethod();

    }
}
