package com.practice.common;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private String name;
    private String email;
    private String phoneNumber;
    private Account PersonalAccount;
}
