package com.fsd.assignment.service;

import com.fsd.assignment.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void delete(Book deleted);
    void deleteById(Long id);
    Optional<Book>  findById(Long id);

    List<Book> findAll();


    Book save(Book persisted);

    Optional<Book> findByBookId(Long id);
}
