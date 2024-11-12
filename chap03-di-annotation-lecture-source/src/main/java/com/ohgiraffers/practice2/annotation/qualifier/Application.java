package com.ohgiraffers.practice2.annotation.qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.practice2");
        String[] beans = context.getBeanDefinitionNames();

        for(String bean : beans){
            System.out.println("bean = " + bean);
        }

        AnimalService animalService = context.getBean("qualifierService", AnimalService.class);

        animalService.animalMethod();
    }
}
