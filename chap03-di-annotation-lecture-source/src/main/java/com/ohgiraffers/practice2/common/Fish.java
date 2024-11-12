package com.ohgiraffers.practice2.common;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Primary
@Order(1)
public class Fish implements Animal{

    @Override
    public void eat() {
        System.out.println("물고기가 플랑크톤을 먹습니다.");
    }
}
