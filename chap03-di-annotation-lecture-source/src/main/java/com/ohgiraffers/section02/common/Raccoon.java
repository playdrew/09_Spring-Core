package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Primary // 2개 이상 설정하게 되면 에러 발생
public class Raccoon implements Animal {

    @Override
    public void eat(){
        System.out.println("너구리가 이탈리안 BLT 를 먹어요");
    }
}
