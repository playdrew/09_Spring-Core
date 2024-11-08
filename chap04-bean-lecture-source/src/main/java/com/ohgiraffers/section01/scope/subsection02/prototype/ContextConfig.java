package com.ohgiraffers.section01.scope.subsection02.prototype;

import com.ohgiraffers.common.Cart;
import com.ohgiraffers.common.Drink;
import com.ohgiraffers.common.Food;
import com.ohgiraffers.common.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class ContextConfig {

    @Bean
    public Product kimchi(){
        return new Food("겉절이",2000,new Date());
    }

    @Bean
    public Product coke(){
        return new Drink("콜라",1500,500);
    }

    @Bean
    public Product soda(){
        return new Drink("밀키스",1800,250);
    }

    @Bean
    /*comment.
    *   @Bean 의 기본 DefaultScope 는 Singleton 이다
    *   하지만 우리가 prototype 이라는 문자열을 @Scope 어노테이션에
    *   전달을 하게 된다면, getBean 으로 객체를 꺼낼 때마다
    *   새로운 인스턴스를 생성해주게 된다.
    * */
    // 기본 스코프가 싱글톤이므로 빈을 데이터위주의 클래스(DTO)를 등록하면 안된다. new 라는 키워드를 사용합니다.
    @Scope("prototype")
    public Cart cart(){
        return new Cart();
    }


}
