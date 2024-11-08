package com.ohgiraffers.section01.scope.subsection01.singleton;

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

        // 첫번째 손님을 위한 쇼핑카드 객체 생성
        Cart cart1 = context.getBean("cart", Cart.class);
        cart1.addItem(kimchi);
        cart1.addItem(soda);

        System.out.println("첫 번째 손님 카트 목록 : " + cart1.showCart());

        // 두번째 손님을 위한 쇼핑카드 객체 생성
        Cart cart2 = context.getBean("cart",Cart.class);
        cart2.addItem(coke);

        // 첫번째 손님이 담은 김치와 밀키스까지 가지고 있어요 실제로는 하나의 인스턴스라는 것이에요
        System.out.println("두 번째 손님 카트 목록 : " + cart2.showCart()); // 두 번째 손님 카트 목록 : [Product(name=겉절이, price=2000) Fri Nov 08 10:34:28 KST 2024, Product(name=밀키스, price=1800) 250, Product(name=콜라, price=1500) 500]
        System.out.println("cart1 = " + cart1.hashCode()); // cart1 = 898694235
        System.out.println("cart2 = " + cart2.hashCode()); // cart2 = 898694235
        
        /*comment. Spring 프레임워크에서 Bean(객체) 의 기본 scope 는
        *          Singleton 이다.
        *          우리가 Bean 으로 등록하면 하나의 인스턴스만 생성을 하며
        *          공유를 해서 사용을 하게 된다.
        * */
        // DTO 는 Bean 으로 등록? Bean 으로 등록할땐 데이터 위주로 하는 클래스는 사용하면 안되요 행위 위주의 클래스를 Bean 으로 등록해요

    }
}
