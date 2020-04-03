package com.springexample.firstspringboot.Services;

import com.springexample.firstspringboot.Model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {


    private List<Book> bookList = new ArrayList<> (Arrays.asList(
            new Book(1L, " Java Basics"),
            new Book(2L, " springBoot Basics"),
            new Book(3L, " Phython Basics")
    ));

    public List<Book> getBookList(){
        return bookList;
    }

    public Book getBook(Long id) {
        return bookList.stream().filter(book -> book.getId() ==1L).findFirst().get();
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void updateBookDetails(Book book, Long id) {

        bookList.stream().filter(bo -> bo.getId() ==id).
                map(b -> {
                    b.setName("new " + book.getName());
                    return b;
                }).collect(Collectors.toList());
    }

    public void deleteBookDetails(Long id) {
    bookList.removeIf(book -> book.getId() == id);
    }
}
