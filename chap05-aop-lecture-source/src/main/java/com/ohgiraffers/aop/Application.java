//
//
//객체지향프로그래밍이면서 관점지향프로그래밍
//중복되는 공통 코드를 분리한다가 핵심 포인트
//코드실행시 그전에 해야할것 그후에 해야할것이 동일하면
//그 친구들을 빼놓은 담에 필요한 부분에서 그때그때 불러다가 쓰는 거에요
//이친구들도 어찌보면 실행전후시점에 공통된 코드를 삽입함으로서 소스코드의 중복을 줄이는게 핵심
//
//메소드의 기능도 공통적인 기능을 한데 묶어서 전달할것만 전달하면 수행하는데
//aop도 메소드 처럼 공통된 코드를 한군데 모아두고 필요시 그때그때 호출한다라고 보면 됩니다.
//
//aop가 가장 많이 쓰는 상황 로그인 시큐리티 트렌잭션
//crud할때 sql session 클로즈 커밋 롤백을 계속 작성했는데
//정상적인 수행이면 커밋 아니면 롤백하고 이런 것들인데 기능마다 커밋 롤백 커밋 롤백 중복되는데
//이런 걸 한군데 모아둔다음에 알아서 끝나면 판단해서 커밋할지 롤백할지 트랜젝션에서 가장 많이 쓰입니다.
//
//트랜젝션은 코드를 작성할 필요없이 골뱅이트랜젝션하면은 알아서 aop가 적용된 기술입니다.
//aop 를 직접적으로 사용하기에는 어려워요. 뭘 공통적으로 빼야할지 감이 안오는..
//aop 기능을 가장 많이 쓰는 건 로깅처리 해당 메소드를 몇번실행 사용자가 이 기능에 몇번 접근 했는지 쓰이고
//트랜잭션에서 많이 쓰이게 됩니다.
//
//aop 의 핵심용어 : aspect 측면입니다. 아래쪽에 보시면 기존 메소드에 주요 코드, 서비스한테 보내는 코드, 전달인자 담아서 메소드 호출하는 구문 , 그런게 있다 치고
//부가코드를 예를 들면 서비스에서 db까지 갔다 오는 시간 측정하고 싶어요 . 주요코드 가 동작전 현재시간 체크 해당 트랜젝션 작업이 끝나면 현재시간 체크후 빼는 코드가 있다해요
//여기서 현재시간을 측정하면 9시 42분예로 들어요 주요코드 데이터베이스에 왓다갓다하는 시간이에요 왓다갓다한다음에 수행된 시간이 9시 44분이라 해요 주요코드가 동작시간은 총2분이죠
//이런식으로 우리가 시간 측정을 하고 싶어요 성능향상을 위해서 이 메서드가 동작하는데 몇분이 걸렸다. 이런식으로 로그를 남기거나 나중을 위해 성능체크하고싶다,
//이런 코드를 어찌보면 시간체크하고 끝나는거체크하고 다음에 끝난 시간과 시작한 시간빼서 총 합계시간하고 이런 것은 무한하게 반복되는 중복된 코드일수 있어요.
//
//        crud를 4개 만들었어요. 시간체크하고 끝나는 시간체크하고 계산하는 것을 crud에 도입할때 시간체크할때 직접작성하는게 아니라 호출하는 거에요
//시간을 체크하는 구문을 한군데만 작성해둔다음에 필요한 곳에 그때그때 호출만 하면 구지 메소드마다 시간체크하는 기능을 사용하지 않아도 되는거에요
//
//public List<MemberDTO> selectAll() {
//    //전체조회시 로직동작 시간
//    //1. 현재 시간 체크 09:42
//    //2. DAO 클래스에 값 전달(호출)
//    //3. 현재 시간 체크 09:45
//    // 4.3-1 = 2번 수행한 시간
//}
//2번 중요한 로직이 얼마나 걸리는지 시간체크 프로젝트를 하다보면 이런 기능이 수도없이 많아요 전체조회 여러명삭제 한명조회 한명삭제 한명삽입 여러명삽입
//crud 이런게 수도없이 많은데 그럴때마다 1번 3번 4번 코드를 다 쓰면 중복되는 코드가 수없이 많아지겠죠.
//
//메소드마다 식을 작성해서 중복적인 코드가 기본적으로 3줄이 추가가 되는거에요 . 시간체크 끝나는시간체크 계산 얘를 한군데다가 정의해놓으면 어떨까..
//정의한다음에 134를 어딘가에 정의한다음에 어디로 들어가야할지 알려주면 중복된 코드를 작성하지 않아도 된다는 것이에요
//
//부가코드를 다른 클래스에 한군데 정의를 해두어서 동작해야할 코드를 정의를 해놓고 여기서 동작을 해라고 하면 지정한 공간에 알아서 동작을 하게 되는거에요
//그래가지고 여기서 나온 용어가 aspect 우리가 작성할 코드들을 말해요 advice는 aspect의 상위호환 느낌이고요. 우리가 작성할 부가코드를 어디다가 위치할지 실행할지
//join point - point cut 이런식으로 어디다 동작할지 정의를 해두어요 . 이 메소드의 앞뒤 앞 뒤 전반적으로 동작을 해라고 명령을 하달할수 있어요
//
//before 어디에 동작을 해라고 지정을 해두면 대상 메소드가 전에 어드바이스라고 하는데 현재시간체크를 비포어로 해요 지정한 코드 전에 먼저 한번 동작을 하게 되요
//        after returning , after throwing 등은 코드를 작성하며서 해둘께요

package com.ohgiraffers.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        // 우리가 작성한 빈들을 읽을 수 있게끔 컨테이너를 구성
        // 전달인자의 설정이 필요
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);

        // 우리가 지금 POINTCUT 에 작성한 메서드를 실행한다 프록시 객체가 낚아채서 해당하는 어드바이스들 joint 아래 메소드
        // before 니까 실행할 메소드가 실행전에 자기껄 수행하는 거에요

        MemberService memberService = context.getBean("memberService",MemberService.class);

        System.out.println("=========================selectMembers=================================");
        System.out.println(memberService.selectMembers());
        System.out.println("==========================selectMember=================================");
        System.out.println(memberService.selectMember(1L));


    }
}
