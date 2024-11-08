package com.ohgiraffers.practice.common;

import java.util.List;

public interface BookDAO {

    List<BookDTO> selectAllBook();
    BookDTO selectBookByNo(int no);
}
