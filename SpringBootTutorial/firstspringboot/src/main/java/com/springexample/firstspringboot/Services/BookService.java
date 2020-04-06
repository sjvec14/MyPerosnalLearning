package com.springexample.firstspringboot.Services;

import com.springexample.firstspringboot.Model.Book;
import com.springexample.firstspringboot.repo.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private IBookRepository bookRepository;
    private List<Book> bookList = new ArrayList<>(Arrays.asList(
            new Book(1L, " Java Basics"),
            new Book(2L, " springBoot Basics"),
            new Book(3L, " Phython Basics")
    ));

    public List<Book> getBookList() {
      //  return bookList;
    List<Book> bookList = new ArrayList<Book>();
    bookRepository.findAll().forEach(bookList::add);
    return bookList;

    }

    public Book getBook(Long id) {

        //return bookList.stream().filter(book -> book.getId() == 1L).findFirst().get();

        return bookRepository.findById(id).get()!=null ? bookRepository.findById(id).get() : null;
    }

    public void addBook(Book book) {

        /*bookList.add(book);*/
        bookRepository.save(book);
    }

    public void updateBookDetails(Book book, Long id) {

        bookRepository.save(book);
        /*bookList.stream().filter(bo -> bo.getId() == id).
                map(b -> {
                    b.setName("new " + book.getName());
                    return b;
                }).collect(Collectors.toList());*/
    }

    public void deleteBookDetails(Long id) {

        bookRepository.deleteById(id);
        //bookList.removeIf(book -> book.getId() == id);
    }
}
