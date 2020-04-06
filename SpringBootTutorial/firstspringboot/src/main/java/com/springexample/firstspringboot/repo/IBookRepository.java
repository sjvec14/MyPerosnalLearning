package com.springexample.firstspringboot.repo;

import com.springexample.firstspringboot.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface IBookRepository  extends CrudRepository<Book, Long> {


}
