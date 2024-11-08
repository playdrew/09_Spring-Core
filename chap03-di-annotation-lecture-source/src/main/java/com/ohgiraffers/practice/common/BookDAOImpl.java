package com.ohgiraffers.practice.common;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("BookDAO")
public class BookDAOImpl implements BookDAO{

    private BookDAO bookDAO;

    public Map<Integer,BookDTO> bookDTOMap;

    public Map<Integer,BookDTO> getBookMap(){
        bookDTOMap = new HashMap<>();
        bookDTOMap.put(1,new BookDTO(1,"name1",10000));
        bookDTOMap.put(2,new BookDTO(2,"name2",20000));
        return bookDTOMap;

    }

    @Override
    public List<BookDTO> selectAllBook() {
        return new ArrayList<>(getBookMap().values());
    }

    @Override
    public BookDTO selectBookByNo(int no) {
        return bookDTOMap.get(no);
    }
}
