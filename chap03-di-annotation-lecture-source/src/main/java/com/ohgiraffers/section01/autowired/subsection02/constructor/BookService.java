package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDAOImpl;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("constructorService")
public class BookService {

    /* comment.
    *       1. 필드 주입은 의존성이 있는 객체가 생성되지
    *          않아도 객체 생성이 가능하다.
    *          따라서 메소드가 호출 될 때 (런타임) 에러가 발생
    *          생성자 주입은 의존성이 있는 객체가 생성되지 않으면
    *          객체의 생성 자체가 불가능하며 컴파일 에러가 팔생한다.
    *       2. 필드에 final 키워드를 쓸 수 있기 때문에 객체의
    *          생성 이후 의존성을 변경할 수 없어 안정성을 보장한다.
    * */
    private final BookDAO bookDAO;

    @Autowired
    // 생성자를 통해 final 을 초기화
    public BookService(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks(){

        // bookDAO = new BookDAOImpl(); // 지금까지도 new 를 사용가능하다 이를 해결하기 위해 필드에 final 선언

        return bookDAO.selectBookList();
    }

    public BookDTO selectOneBook(int no){
        return bookDAO.selectBookByNo(no);
    }
}
