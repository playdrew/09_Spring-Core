package com.ohgiraffers.practice.autowired;

import com.ohgiraffers.practice.common.BookDTO;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.practice");
        BookService bookService = context.getBean("constructor", BookService.class);

        List<BookDTO> booklist = bookService.BookDTOList();

        for(BookDTO bookDTO : booklist){
            System.out.println("bookDTO = " + bookDTO);
        }
        System.out.println(bookService.bookDTO(1));
    }
}
