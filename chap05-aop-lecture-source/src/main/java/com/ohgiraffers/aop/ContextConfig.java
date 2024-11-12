package com.ohgiraffers.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.ohgiraffers.aop")
// aop 라는 폴더및에 빈으로 등록한 것을 스캔하도록
public class ContextConfig {

}
