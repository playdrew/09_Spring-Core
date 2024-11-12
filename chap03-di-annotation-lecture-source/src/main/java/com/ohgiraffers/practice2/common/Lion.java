package com.ohgiraffers.practice2.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("Lion")
@Order(2)
public class Lion implements Animal {

    @Override
    public void eat() {
        System.out.println("사자가 고기를 먹습니다");
    }
}
