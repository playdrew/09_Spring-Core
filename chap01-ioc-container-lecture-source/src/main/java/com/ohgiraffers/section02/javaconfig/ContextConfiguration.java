package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* comment. @Configuration 어노테이션은 해당 클래스가
*           빈을 생성하는 클래스임을 컨테이너에게 알려준다.*/
@Configuration("configuration")
public class ContextConfiguration {
    
    /* 1명의 회원을 Bean 등록 */
    /* comment. @Bean 어노테이션은 해당 메소드의 반환 값을 컨테이너에
    *           Bean(객체) 로 등록하겠다는 의미이다.
    *           이름을 별도로 지정하지 않으면 메소드 이름을 id로 인식한다
    * */
    // @Bean 설정을 하지 않으면 getMember 가 아이디 입니다. name 을 설정하면 member 가 id 입니다.
    @Bean(name="member")
    public MemberDTO getMember(){
        return new MemberDTO(2,"user02","pass02","조팽팽");
    }
}
