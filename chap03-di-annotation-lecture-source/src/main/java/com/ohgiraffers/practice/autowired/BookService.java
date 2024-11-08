package com.ohgiraffers.practice.autowired;


import com.ohgiraffers.practice.common.BookDAO;
import com.ohgiraffers.practice.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("constructor")
public class BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO){
        this.bookDAO=bookDAO;
    }

    public List<BookDTO> BookDTOList(){
        return bookDAO.selectAllBook();
    }

    public BookDTO bookDTO(int no){
        return bookDAO.selectBookByNo(no);
    }
}
