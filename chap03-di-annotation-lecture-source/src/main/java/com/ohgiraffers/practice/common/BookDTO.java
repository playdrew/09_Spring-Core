package com.ohgiraffers.practice.common;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private int no;
    private String name;
    private int price;
}
