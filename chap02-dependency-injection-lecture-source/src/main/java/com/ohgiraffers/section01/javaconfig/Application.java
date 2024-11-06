package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        // 설정 파일 정보 전달
        // IOC 컨테이너 만들기
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // 빈 등록한 것을 컨테이너에서 꺼내기
        // 멤버와 계좌의 연결
        MemberDTO member = context.getBean(MemberDTO.class);

        System.out.println(member.getPersonalAccount());
        System.out.println(member.getPersonalAccount().deposit(10000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().withDraw(5000));

    }
}
