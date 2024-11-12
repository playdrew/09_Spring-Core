package com.practice.section;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// annotation
@Component
public class Owner1 {

    @PostConstruct
    public void openShop(){
        System.out.println("1 shop 을 열었습니다");
    }

    @PreDestroy
    public void closeShop(){
        System.out.println("1 shop을 닫았습니다.");
    }
}
