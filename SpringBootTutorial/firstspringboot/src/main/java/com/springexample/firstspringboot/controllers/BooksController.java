package com.springexample.firstspringboot.controllers;


import com.springexample.firstspringboot.Model.Book;
import com.springexample.firstspringboot.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;
    @RequestMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBookList();
    }

    @RequestMapping("/books/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @RequestMapping(method = RequestMethod.POST , value ="/books")
    public void addBook(@RequestBody  Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT , value ="/books/{id}")
    public void updateBook(@RequestBody  Book book,@PathVariable Long id) {
        bookService.updateBookDetails(book, id);
    }

    @RequestMapping(method = RequestMethod.DELETE , value ="/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookDetails(id);
    }
}
