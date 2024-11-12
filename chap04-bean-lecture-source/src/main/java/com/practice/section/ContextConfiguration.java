package com.practice.section;

import com.practice.common.Cart;
import com.practice.common.Drink;
import com.practice.common.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class ContextConfiguration {

    @Bean
    public com.practice.common.Product kimchi(){
        return new Food("kimchi",5000,new Date());
    }

    @Bean
    public com.practice.common.Product coke(){
        return new Drink("coke",2200,500);
    }

    @Bean
    public com.practice.common.Product soda(){
        return new Drink("soda",1100,800);
    }

    @Bean
    @Scope("prototype")
    public Cart cart(){
        return new Cart();
    }


    @Bean(initMethod = "openShop",destroyMethod = "closeShop")
    public Owner2 owner2(){
        return new Owner2();
    }
}
