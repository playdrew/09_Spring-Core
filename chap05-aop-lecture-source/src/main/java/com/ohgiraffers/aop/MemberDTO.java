package com.ohgiraffers.aop;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// set 으로 값넣고 get 으로 꺼내오는게 핵심
// lombok 을 쓰더라도 getter setter 의 의미 잊지 않기
public class MemberDTO {

    private Long no;
    private String name;
}
