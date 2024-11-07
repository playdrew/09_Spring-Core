package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for(String bean : beanNames){
            System.out.println("bean = " + bean);
        }

        // 컨테이너에서 Service 빈을 가져온다음에 사용할 준비를 마침
        AnimalService animalService = context.getBean("qualifierService", AnimalService.class);

        // primary 를 작성하면 최초에 어디에 갈지 작성할 수 있다.
        animalService.animalEat();

    }
}
