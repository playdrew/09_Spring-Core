package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDAOImpl;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component 어노테이션 세분화 된 @Service 어노테이션
// Service 계층에서 사용된다.
@Service("fieldService")
public class BookService {

    // private BookDAO bookDAO = new BookDAOImpl();
    // 위의 과정을 아래처럼 치환한다.
    // Autowired 를 필드에 작성하냐 생성자에 작성하냐 setter 에 작성하냐에 따라 갈리는 것
    @Autowired
    private BookDAO bookDAO;
    
    /* 전체 조회기능 호출 */
    public List<BookDTO> selectAllBooks(){

        /* comment.
        *   Spring 에서 의존성 주입
        *   미리 Bean 으로 컨테이너 등록해둔 객체를
        *   필요 시에 @Autowired 어노테이션으로
        *   가져다가 쓰는 개념이다.
        *   따라서 개발자는 new 키워드로 객체를 생성하는
        *   것이 아닌, 컨테이너에 존재하는 객체를 가져와야
        *   한다.
        * */

        // bookDAO = new BookDAOImpl(); // bookDAO 변수에 새로운 객체를 덮어쓸수 있는데 필드주입을 하면 new 라는 키워드를 제약 없이 사용가능

        return bookDAO.selectBookList();
    }

    /* 번호로 책 한권 조회 기능 호출 */
    public BookDTO selectedOneBook(int no){
        return bookDAO.selectBookByNo(no);
    }
}
