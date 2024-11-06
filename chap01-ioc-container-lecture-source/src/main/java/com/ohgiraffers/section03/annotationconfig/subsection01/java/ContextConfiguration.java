package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 위에서 아래로 흝으면서 컴포넌트어노테이션을 빈으로 등록해주는 역할
// basePackages = "" 는 범위를 지정하는 것
/* comment. @Configuration 어노테이션은 해당 클래스가
*           빈을 생성하는 클래스임을 컨테이너에게 알려준다.*/
@Configuration("configuration03")
// test01
//@ComponentScan(basePackages = "com.ohgiraffers" )
// test02
@ComponentScan(basePackages = "com.ohgiraffers",
        excludeFilters = {
            @ComponentScan.Filter(
                    /* 1. 타입으로 지정 */
//                    type = FilterType.ASSIGNABLE_TYPE,
//                    classes = {MemberDAO.class}
                    /* 2. 어노테이션 종류로 설정 */
//                    type = FilterType.ANNOTATION,
//                    classes = {org.springframework.stereotype.Component.class}
                    /* 3. 표현식으로 설정 */
                      type = FilterType.REGEX,
                      pattern = {"com.ohgiraffers.section03.annotationconfig.java.*"}
            )
        }
)
public class ContextConfiguration {
}
