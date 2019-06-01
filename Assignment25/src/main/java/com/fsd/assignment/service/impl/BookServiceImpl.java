package com.fsd.assignment.service.impl;

import com.fsd.assignment.dao.BookJpaRepository;
import com.fsd.assignment.entity.Book;
import com.fsd.assignment.service.BookService;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    BookJpaRepository bookJpaRepository;

    @Override
    public Optional<Book> findById(Long id) {
        return bookJpaRepository.findByBookId(id);
    }

    @Override
    public void delete(Book deleted) {

    }

    @Override
    public void deleteById(Long id) {
        bookJpaRepository.delete(id);
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book save(Book persisted) {
        return bookJpaRepository.save(persisted);

    }

    @Override
    public Optional<Book> findByBookId(Long id) {
        return Optional.empty();
    }
}
