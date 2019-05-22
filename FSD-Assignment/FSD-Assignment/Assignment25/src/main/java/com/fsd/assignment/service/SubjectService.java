package com.fsd.assignment.service;

import com.fsd.assignment.entity.Book;
import com.fsd.assignment.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    void delete(Subject deleted);
    void deleteById(Long id);

    Optional<Subject> findById(Long id);


    List<Subject> findAll();


    Subject save(Subject persisted);
}
