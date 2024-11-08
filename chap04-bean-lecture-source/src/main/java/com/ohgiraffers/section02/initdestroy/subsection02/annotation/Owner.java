package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// 특수한 목적을 가진 녀석이 아니어서 대충 빈으로 등록해란 어노테이션
@Component
public class Owner {

    // Jakarta Annotations API  2.1.1
    // 생성되기 전에 동작
    @PostConstruct// init-method 빈 생성 전 동작하는 메소드
    public void openShop(){
        System.out.println("사장님이 가게 문 열었습니다. 쇼핑이 가능합니다");
    }
    
    @PreDestroy // destroy-method 컨테이너 종료 시 동작하는 메소드
    public void closeShop(){
        System.out.println("사장님이 가게 문을 닫았습니다. 빠~위");
    }
}
