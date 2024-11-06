package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        
        /* Index 1. xml 방식으로 컨테이너 구성 */
        // 인터페이스라서 구현체가 필요함 GeneralXmlApplicationContext 와 AnnotationApplicationContext
        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        // bean 의 id를 이용해서 객체 가져오는 방법
        // MemberDTO member = (MemberDTO) context.getBean("member");
        
        // bean 의 클래스 정보를 전달하여 가져오는 방법
        // MemberDTO member = context.getBean(MemberDTO.class);

        // bean 의 id와 클래스 정보를 전달하여 가져오는 방법
        // 메서드의 오버로딩 기능 활용
        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println("member = " + member);
    }
}
