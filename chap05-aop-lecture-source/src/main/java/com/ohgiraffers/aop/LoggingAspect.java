package com.ohgiraffers.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Map;

/* @Aspect 어노테이션 : AOP 기능을 사용하기 위한 어노테이션 */
// 중간 중간 측면에 들어간다라고 해서
// 빨간불뜨는데 의존성추가해야한다는 것이에요
@Aspect
@Component
public class LoggingAspect {

    // 이 클래스는 반복적으로 동작할 코드를 해당하는 클래스에 놓을 것입니다.
    // 어찌보면 이들도 빈들 사이에서 들어왓다 나왓다하니까 스프링컨테이너가 관리하게끔 컴포넌트 어노테이션 작성
    
    /* comment. 
    *   @PointCut - 여러 조인 포인트를 매칭하기 위한 표현식
    *   사용식
    *   @PointCut("execution([수식어] 리턴타입 [클래스 이름].이름(파라미터)")
    *   수식어란 , public-private-protected-default 등의 접근제어자를 의미하며
    *   생략이 가능하다.
    *   * -> 와일드 카드 (전부 가능하다는 의미)
    *   *Service -> 이름이 Service 로 끝나는 클래스를 의미한다.
    *   *Service.*(..) -> 매개변수가 0개 이상인 모든 메소드
    *   *Service.*(*) -> 매개변수가 1개인 모든 메소드
    *   *Service.*(*,..) -> 매개변수가 1개 이상인 모든 메소드
    *     * */
    // 조인 포인트 : 조인은 결합된 포인트라고 하는데 서비스 클래스에 로직작성을 했는데 비즈니스로직에 어떤 로직에 접근할거냐 즉 조인(결합)할거냐
    // aspect advice 는 조금 하나라고 보신 다음에 별도로 작성해둔 코드가 조인포인트 어떤 위치에서 실행될지 어느 포인트에 접속을 시킬건지
    // 조인 포인트를 정의하는 것을 포인트 컷이라고 하는 것입니다.

    // 가장 첫번째로 올게 별을 의미했는데 public-private-protected-default 상관없이 전부
    // 수식어 공간에 별을 작성했고 전부다 가능하다는 것이고요. 그 다음에 리턴타입 *Service
    // aop 라는 폴더까지 선택을 했고 그 다음에 별표 서비스라는 것은 memberService 뿐만 아니라 MenuService 이런 식으로 클래스 작성시
    // 서비스 붙은 것은 전부다 인식을 하겠다라는 것이에요 전치사 서비스 단어앞에 어떤게 붙던간에 허용을 하겠다라는 것이고요
    // Service 에 . 하면 필드나 메소드에 접근가능하다 .
    // MemberService memberService = new MemberService(); memberService.selectAll()
    // 해당 클래스의 인스턴스생성 메소드 호출하잖아요 클래스가 가진 소괄호 매서드에 접근하겠다 이때 메소드 이름을 설정하는데
    // 모든 메소드를 가져오겠다는 것입니다. 소괄호 내부에 .. 이라고 했잖아요 소괄호 내부에는 전달인자를 보내는데
    // .. 이란 전달인자가 몇개든 상관없다는 것입니다.
    // 그러면 포인트컷으로 지정한게 뭐냐면 모든 public-private-protected-default 접근 가능하고
    // 어떤 메소드에 접근하면 Service 로 클래스명으로 끝나는 모든 메소드 .. 이라고 했는데 .. 이라는 매개변수가 없어도 되고 많아도 되고
    // Service 클래스에 접근하고 서비스클래스가 가진 모든 메소드 매개변수가 0개 이상인 selectMembers selectMember 에도 접근할 수 있다는 것이에요

    @Pointcut("execution(* com.ohgiraffers.aop.*Service.*(..))")
    public void logPointCut(){

    }

    /* comment.
    *   JoinPoint : 포인트 컷으로 설정한 실행 지점을 의미한다.
    *   
    * */
    
    // 비포어 어노테이션에 String 으로 넣을 수 있는데
    // 여기다 스트링타입으로 우리가 하고 있는 로깅에스팩트란 클래스에 위에 작성한 로그포인트컷메소드를 전달을 해볼께요
    @Before("LoggingAspect.logPointCut()")
    public void logBefore(JoinPoint joinPoint){
        // 그러면 ~하기 전이래요 문자열로 어떤 메소드를 집어넣었는데
        // 위에서 어디서 실행해야하는 위치정보를 담았어요
        // 이 메서드는 전에 동작을 할 것이에요 
        // 어떤 곳 전이냐 우리가 지정한 위치 전에 동작을 한다는 것이에요
        System.out.println("Before 타켓 정보 : " + joinPoint.getTarget());
        System.out.println("Before 타켓의 시그니쳐 : " + joinPoint.getSignature());
        // 아까 전달인자가 없는 것과 no 를 넘기는 두가지가 있었어요 전달인자가 있으면 출력하는 구문을 작성을 한 것입니다.
        if(joinPoint.getArgs().length >0){
            System.out.println("Before 타켓의 인자 : " + joinPoint.getArgs()[0]);
        }
    }
    
    // 이것만 적으면 안되요 contextConfig 로 이동
    // @EnableAspectJAutoProxy(proxyTargetClass = true) 어노테이션 추가
    // 수업자료에서 프록시가 나와요 쁘락지 정보가로채서 여기저기 알려주는애
    // 프록시가 뭐냐면 빈들과 빈들사이에 호출하고 리턴받고 하는 것들이 있어요
    // 프록시 AOP 는 우리가 서비스 클래스 메소드 동작할때 쁘락지가 낚아채요
    // BEFORE 에 설정한 것들을 여기 출력구문 세개를 출력한담에 다시 갔다주는 것이에요
    // 마치 필터같이요 AOP 는 스프링컨테이너에 필터같은 녀석
    // 프록시 라고 해서 공간에 요청을 보내면 포인트컷에 설정한 메소드 들을 프록시가 중간에 낚아채요
    // 아이피 우회할때 프록시서버 그런 것들 처럼 요청을 보내면 중간에 낚아채서 ASPECT 메소드 작성 내용을 실행시킨다음에 가는 거에요
    // 이게 프록시를 사용하겠다 라는 것을 의미합니다
    // 우리가 지금 POINTCUT 에 작성한 메서드를 실행한다 프록시 객체가 낚아채서 해당하는 어드바이스들 joint 아래 메소드
    // before 니까 실행할 메소드가 실행전에 자기껄 수행하는 거에요

    // 조인포인트라는 객체는 위쪽에서 설정한 해당하는 정보들을 가지고 있어요 JoinPoint

    /* comment.
    *       JointPoint : 포인트 컷으로 설정한 실행지점을 의미한다.
    *       실행 지점을 설정을 하게 되면 우리가 매서드내에 작성한 코드(Advice)
    *       를 어노테이션의 종류에 따라 전, 후 , 전후 등등에 동작하게 할 수 있다.
    *       메소드의 매개변수로 전달한 JoinPoint 객체는 현재 조인 포인트의
    *       매소드명 , 인수 , 정보등등을 가지고 있게 된다.
    * */

    // 조인포인트란 매개변수는 설정한 위치정보에 기반하여 해당 메소드 클래스에 대한 정보를 가지고 있게 됩니다.
    // 조인포인트란 객체가 가지고 있게 되고요
    // before 를 해봤으니 after 도 해보죠
    // 아깐 클래스명.메소드명으로 접근을 했는데
    /* 같은 클래스 내에 PointCut 을 설정했다면 클래스명은 생략가능
       만약 다른 클래스에 PointCut 을 설정했다면 클래스명은
       풀클래스명(패키지포함)으로 작성해야한다.*/
    // 다른 클래스면 클래스명쓰는 것은 필수 입니다.
    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After 타켓 정보 : " + joinPoint.getTarget());
        System.out.println("After 타켓의 시그니쳐 : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length >0){
            System.out.println("After 타켓의 인자 : " + joinPoint.getArgs()[0]);
        }
    }

    /* comment. @AfterReturning 어노테이션
    *           리턴한 결과 값을 변경할 수 있다.
    *           returning 속성
    *           - 메서드가 동작을 완료하고 자신을 호출한 쪽으로 가져가는 값
    *           - 즉 리턴 값을 담아둘 변수명을 기술한다.
    **/
    // 회원에 대한 정보 출력 반환값들이 존재
    // 어플리케이션에서 서비스클래스를 호출하고요 dao 를 호출하고 있어요
    // 그렇다는 것은 서로서로 리턴하고 있죠. 서비스 클래스는 어플리케이션이 돌때 값들을 가지고 있는데
    // 프록시 aop 라는 기능을 공간에 침투해서 실행시키고 끝나면 하고 (요청시)
    // 리턴하는 과정에 멤버를 가져가는 도중에 중간에 탈취가 가능합니다
    // 리턴값을 뭔가 수정을 할 수 있다는 것입니다.
    // 친구가 불려지고 나면 dao 에서 멤버를 가지고 어플리케이션을 떠나죠
    // 근데 aop 는 가지고 떠날때 (응답) 중간에 탈취를 할 수 있어요
    // 리턴값을 변경할 수 있다는 것이에요 
    // 변경할때 사용하는 aop 의 기능이 AfterReturning 기능
    // 이 친구는 결과값을 수정해요 즉 메서드내에서 리턴값을 지지고 볶아요
    // 어딘가 저장을 해야 사용 두번째 인자에 리터닝이라는 속성에 result 라고 작성
    // 어디서 실행할지 정보를 담은 조인포인트와 리턴값을 가지고 뭔가를 해야해요 두번째 인자로 모든 객체의 조상
    // 오브젝트 타입으로 리터닝에 작성해뒀던 변수명을 기술
    // 앞뒤로 after 와 before 설정했는데 리턴값도 뭔가 사용할 수 있다는 것이에요
    // 여기서 많이 힘든데 aop는 용어들이 어려워요
    // 이 메소드 앞으로 after before 설정했는데요 selectMembers selectMember 그렇다면 리턴되는 값도
    // 불렀던 쪽으로 갈때 사용할 수 있다는 것이에요 첫번째 메소드를 보면 selectAllMembers 두명회원에 대한 정보를 가지고
    // 어플리케이션쪽으로 가는데 맵형태에 두명회원에 대한 정보는 맵형테에 롱에 dto타입이에요
    // 맴버맵타입에 담을 공간을 object result 라고 리턴값을 담기 위한 준비를 한 것이에요
    // returning 속성은 변수명을 기술하고 Returning이라는 녀석은  결과값을 조작해야하기 때문에
    // 결과값을 가진 매개변수 Object result 설정하는 것이에요 이 두가지의 이름은 항상 일치해야합니다.
    @AfterReturning(pointcut = "logPointCut()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint,Object result){
        System.out.println("result 변수에 Service 에서 return 되는 값이 담겼나? : " + result);
        // result . 하면 임의로 데이터조작도 가능해집니다.
        /* comment. result 변수에 우리가 Service 클래스에서 return 되는 값이
        *           담긴 것을 확인 했다. 그렇다는 것은 우리가 result 변수에
        *           접근해서 값을 조작할 수 있다는 의미로 해석할 수 있다.*/
        if(result != null && result instanceof Map){
            ((Map<Long,MemberDTO>) result).put(100L,new MemberDTO(100L,"반환되는 값 가공 성공!!"));
        }
    }

    /* comment. @AfterThrowing
                */
    // 아까 Returning 쪽에서는 pointCut 해당하는 리터닝에 대한 속성과 값을 담을 result 이름을 동일하게 매칭시켰다면
    // 이 친구도 마찬가지로 변수명과 매개변수로 받고 있는 녀석을 일치시켜주어야 합니다.
    // afterThrowing 이라는 녀석은 에러가 발생했을때 뭔가를 추가적으로 해야하겠다라고 사용하는데
    // 5번 회원에 대한 에러가 발생했다라고 해도 뷰페이지에서 보여주면 되지 애프터스로잉해서 크게 할건 없어요
    // 스로잉 같은 경우에는 가볍게 넘겨요
    @AfterThrowing(pointcut = "logPointCut()" , throwing = "exception")
    public void logAfterThrowing(Throwable exception){
        System.out.println("exception" + exception);
    }

    // aop 에서 가장 강력한 녀석
    /* comment @Around
    *          - Around 는 우리가 지정한 실행 위치(JoinPoint) 앞 뒤를 모두 장악한다
    *          - 그리고 타겟 메소드의 실행 시점, 실행 여부,  계속 진행 여부 등을 결정한다.
    *          - Around Advice 는 JoinPoint 를 확장한 ProceedingJoinPoint 를
    *          - 매개변수로 받게 된다.*/
    // 이름만 보면 감싸고 돌아다닌 느낌 after before 합친것
    // 조인포인트의 장악
    // 저희는 앞뒤로 동작하게끔했는데 지정한 JoinPoint 를  타겟을 직접 실행시켜서
    // 실행시점 실행여부 진행여부 메소드에 대한 전권을 가지고 있는거에요
    // 전까지 기능은 네임기능 앞뒤로 움직였는데 해당하는 어라운드를 네임기능을 어느시점에 동작시킬지까지 하는 
    // 해당하는 어라운드는 조인포인트를 확장한 프로시딩 프로시딩이라는 것은 진행이란 뜻이고 
    // 프로시딩조인포인트는 타겟메소드를 진행할지 진행하지 않을지 까지 결정할 수 있게 되요
    @Around("logPointCut()")
    // 어라운드 어드바이스는 반환형을 가지고 있어요 어브젝트
    // 조인포인트를 확장한 프로시딩조인포인트
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        /* comment. 
        *   앞 뒤로 동작을 하게 되므로 여기서는 메소드 실행 시 
        *   소요되는 시간을 체크하는 로직 작성
        * */
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(); // 시간을 재는 스탑워치 실행
        System.out.println("Around Before : " + joinPoint.getSignature().getName());
        // 핵심이 반환형이 있고 실행여부를 우리가 결정해요
        // Target 메소드 시작시키는 구문 proceed 는 예외처리 필수입니다.
        // joinPoint.proceed 위는 before 아래는 after
        // 어라운드는 before 에 타임워치 키고 after 타입워치 끄고 하는게 더 좋다고 합니다.
        Object result = joinPoint.proceed();
        System.out.println("Around After : " + joinPoint.getSignature().getName());
        stopWatch.stop();
        System.out.println("메소드 실행에 소요된 시간 : " + stopWatch.getTotalTimeMillis() + "ms");

        /* comment. 조인 포인트를 호출한 쪽(지금은 Application)
        *           or 다른 어드바이스가 실행 할 수 있도록 Object 반환
        *           */
        return result;
    }

    // 스탑워치를 실행한 다음에 지정한 메소드를 알아서 동작하는게 아니라 진행해라는 명령을 내려요
    // 진행을 하고 나서 Object result 진행한 결과가 담기게 되고요
    // 인제 진행 메서드 동작을 하고나서 아래식으로 내리게 되니까 스탑워치를 스탑을 시켜볼께요.
    // 이런 식으로 시간까지 출력을 해봤으니까
    // 이번엔 모든 서비스클래스에 있는 메소드에 시작하기전 스톱워치키고 끝나면 스톱워치 끄고 그리고 걸리는 시간이 몇초인지 출력하는 구문을 작성
    // 저 어라운드라는 녀석은 프로시드란 명령으로 조인포인트를 대한 메서드 실행 우리가 aop 라는 녀석이 프로시드라는 녀석을 작성을 반드시 해주어야해요
    // 오브젝트 타입을 반환한다는 것은 result 반환 값을 가지고 얼마든지 조작할수있다는 것입니다.
}
