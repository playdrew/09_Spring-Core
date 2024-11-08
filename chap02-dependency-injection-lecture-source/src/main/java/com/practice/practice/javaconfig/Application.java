package com.practice.practice.javaconfig;

import com.practice.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);

        MemberDTO member = context.getBean(MemberDTO.class);

        System.out.println(member);
        System.out.println(member.getPersonalAccount().deposit(10000));
        System.out.println(member.getPersonalAccount().balance());
        System.out.println(member.getPersonalAccount().withdraw(5000));
    }
}
