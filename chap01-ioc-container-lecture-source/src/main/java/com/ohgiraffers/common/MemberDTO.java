package com.ohgiraffers.common;

import lombok.*;


@NoArgsConstructor  //기본생성자
@AllArgsConstructor  // 매개변수있는 생성자
@Getter
@Setter
@ToString
// @Data -> 위에 5 가지 수행할 수 있지만
// Lombok 자체의 버그가 많이 권장하지 않음
public class MemberDTO {

    private int no;
    private String id;
    private String pwd;
    private String name;


}
