package com.ohgiraffers.practice2.common;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Rabbit implements Animal {
    @Override
    public void eat() {
        System.out.println("토끼가 풀을 먹습니다.");
    }
}
