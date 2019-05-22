package com.fsd.assignment.dao;

import com.fsd.assignment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface BookJpaRepository extends CrudRepository<Book,Long > {

    void delete(Book deleted);

    List<Book> findAll();


    Book save(Book persisted);

    Optional<Book> findByBookId(Long id);

}
