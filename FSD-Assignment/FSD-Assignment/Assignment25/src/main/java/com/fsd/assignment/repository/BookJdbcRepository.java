/*
package com.fsd.assignment.repository;

import com.fsd.assignment.entity.Book;
import com.fsd.assignment.entity.Subject;
import com.fsd.assignment.mapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BookJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> findAll(){

        String sql = "SELECT * FROM BOOK";


        List<Book> books  = jdbcTemplate.query(sql,
                new BookRowMapper());

        return books;
    }

    public Book findById(long id) {
        return jdbcTemplate.queryForObject("select * from book where id=?", new Object[]{
                        id
                },
                new BookRowMapper());
    }

   */
/* public int insert(Book book) {
        return jdbcTemplate.update("insert into book (id, name, passport_number) " + "values(?,  ?, ?)",
                new Object[] {
                        book.getId(), book.getName(), book.getPassportNumber()
                });
    }*//*


    public int deleteById(long id) {
        return jdbcTemplate.update("delete from book where id=?", new Object[] {
                id
        });
    }

}
*/
