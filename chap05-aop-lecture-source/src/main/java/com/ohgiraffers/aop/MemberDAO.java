package com.ohgiraffers.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
// DAO 클래스는 데이터베이스와 연결하기 위한 마지막 객체이므로 컴포넌트가 아닌 역할을 가진 레파지토리라고 작성
public class MemberDAO {
    
    /* 아직 DB 접속은 하지 않을 것이기 때문에 임시 DB 생성 */
    private final Map<Long,MemberDTO> memberMap;
    
    // 멤버 dao 객체가 등록이 될 때 빈으로서 인식이 될때 해당하는 데이터를 생성
    public MemberDAO(){
        memberMap = new HashMap<>();
        memberMap.put(1L,new MemberDTO(1L,"조평훈"));
        memberMap.put(2L,new MemberDTO(2L,"조팽팽"));
    }

    // 회원 전체 조회
    public Map<Long,MemberDTO> selectAllMembers(){
        return memberMap;
    }

    // 회원 번호로 회원 전체
    public MemberDTO selectMemberByNo(Long no){
        MemberDTO selectedMember = memberMap.get(no);
        if(selectedMember == null){
            throw new RuntimeException("해당하는 " + no + "번째 회원은 없습니다");
        }
        return selectedMember;
    }
}
