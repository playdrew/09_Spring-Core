package com.practice.section;


import com.practice.common.Cart;
import com.practice.common.Drink;
import com.practice.common.Food;
import com.practice.common.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(PropertiesConfiguration.class);

        String[] beans = context.getBeanDefinitionNames();

        for(String bean : beans){
            System.out.println("bean = " + bean);
        }

        Product kimchi = context.getBean("kimchi", Food.class);
        Product coke = context.getBean("coke", Drink.class);
        Product soda = context.getBean("soda",Drink.class);

        Cart cart1 = context.getBean("cart",Cart.class);
        cart1.addItem(kimchi);
        cart1.addItem(coke);
        System.out.println("cart1 목록 : " + cart1.printProductList() + ", cart1 해쉬코드 : " + cart1.hashCode());


        Cart cart2 = context.getBean("cart",Cart.class);
        cart2.addItem(soda);
        System.out.println("cart2 목록 : " + cart2.printProductList() + ", cart2 해쉬코드 : " + cart2.hashCode());

        ((AnnotationConfigApplicationContext)context).close();

    }
}
