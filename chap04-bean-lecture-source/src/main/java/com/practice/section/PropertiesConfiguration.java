package com.practice.section;

import com.practice.common.Cart;
import com.practice.common.Drink;
import com.practice.common.Food;
import com.practice.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Date;

@Configuration
@ComponentScan("com.practice.section")
@PropertySource("section03/properties/product-info.properties")
public class PropertiesConfiguration {

    @Value("${food.kimchi.name}")
    private String kimchiName;

    @Value("${food.kimchi.price}")
    private int kimchiPrice;

    @Value("${drink.coke.name}")
    private String cokeName;

    @Value("${drink.coke.price}")
    private int cokePrice;

    @Value("${drink.coke.capacity}")
    private int cokeCapacity;

    @Value("${drink.soda.name}")
    private String sodaName;

    @Value("${drink.soda.price}")
    private int sodaPrice;

    @Value("${drink.soda.capacity}")
    private int sodaCapacity;

    @Bean
    public Product kimchi(){
        return new Food(kimchiName,kimchiPrice,new Date());
    }

    @Bean
    public Product coke(){
        return new Drink(cokeName,cokePrice,cokeCapacity);
    }

    @Bean
    public Product soda(){
        return new Drink(sodaName,sodaPrice,sodaCapacity);
    }

    @Bean
    @Scope("prototype")
    public Cart cart(){
        return new Cart();
    }

    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner2 owner(){
        return new Owner2();
    }


}
