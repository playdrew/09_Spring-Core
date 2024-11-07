package com.ohgiraffers.section01.common;

import lombok.*;

import java.util.Date;


// DTO 는 빈으로 등록하지 않습니다. 빈은 싱글톤입니다.
// 1번 회원이 장바구니에 뭔가를 담으면 2번 회원도 1번회원이 담습니다.
// 빈은 설정관련데이터 클래스단위 (Controller ,Service , DAO) 만 합니다.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {

    private int no;         // 번호
    private int isbn;       // 책 일련번호
    private String title;   // 책 제목
    private String author;  // 저자
    private String publisher;   // 출판사
    private Date createdDate;
}
