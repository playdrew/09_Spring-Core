package com.ohgiraffers.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

// DAO 를 호출할 서비스 클래스 호출
// 빈으로 등록하기 위한 서비스 어노테이션
@Service
public class MemberService {

    // 어플리케이션에서 컨트롤러 계층을 생략을 한 다음에 서비스를 호출하고
    // 서비스는 DAO 계층을 호출할 것이에요
    // 다른 클래스를 사용하기 위해선 의존성 주입을 해야해요.
    // 다른 클래스와 다른 클래스를 연결하기 위해 의존성을 주입을 해요 
    // 생성자 주입으로 해요
    private final MemberDAO memberDAO;

    /* 생성자 주입으로 Bean 들과 의존성 생성 */
    @Autowired
    public MemberService(MemberDAO memberDAO){
        this.memberDAO = memberDAO;
    }

    // 구두상으로 서비스 메소드가 실행됨을 표시했는데 전과 후에 동작할 구문을 구분하겠다.
    // 전체 조회하는 DAO 로직 호출하는 구문
    public Map<Long, MemberDTO> selectMembers(){
        System.out.println("selectMembers. 메소드 실행됨");
        return memberDAO.selectAllMembers();
    }

    // 회원 번호로 조회하는 dao 로직 호출하는 구문
    public MemberDTO selectMember(Long no){
        System.out.println("selectMeber 메소드 실행됨");
        return memberDAO.selectMemberByNo(no);
    }
}
