package com.practice.practice.javaconfig;

import com.practice.common.Account;
import com.practice.common.MemberDTO;
import com.practice.common.PersonalAccount;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Account account(){
        return new PersonalAccount(1,"1-1-0");
    }

    @Bean
    public MemberDTO memberDTO(){
        return new MemberDTO("jsc","jsc@gmail.com","010-2424-2332",account());

    }
}
