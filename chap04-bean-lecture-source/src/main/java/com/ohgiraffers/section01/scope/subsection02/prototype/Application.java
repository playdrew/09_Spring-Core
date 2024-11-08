package com.ohgiraffers.section01.scope.subsection02.prototype;


import com.ohgiraffers.common.Cart;
import com.ohgiraffers.common.Drink;
import com.ohgiraffers.common.Food;
import com.ohgiraffers.common.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        // ioc 컨테이너 구성
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);

        // 빈들의 이름을 꺼낼 수 있는 메소드
        String[] beanNames = context.getBeanDefinitionNames();

        for(String bean : beanNames){
            System.out.println("bean = " + bean);
        }

        Product kimchi = context.getBean("kimchi", Food.class);
        Product coke = context.getBean("coke", Drink.class);
        Product soda = context.getBean("soda", Drink.class);

        Cart cart1 = context.getBean("cart", Cart.class);
        cart1.addItem(kimchi);
        cart1.addItem(soda);

        System.out.println("첫 번째 손님 카트 목록 : " + cart1.showCart());

        Cart cart2 = context.getBean("cart",Cart.class);
        cart2.addItem(coke);


        System.out.println("두 번째 손님 카트 목록 : " + cart2.showCart());
        System.out.println("cart1 = " + cart1.hashCode());
        System.out.println("cart2 = " + cart2.hashCode());



    }
}
