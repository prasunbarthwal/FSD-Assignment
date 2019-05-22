/*
package com.fsd.assignment.repository;

import com.fsd.assignment.entity.Book;
import com.fsd.assignment.entity.Subject;
import com.fsd.assignment.mapper.SubjectRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


public class SubjectJdbcRespository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Subject> findAll(){

        String sql = "SELECT * FROM SUBJECT";


        List<Subject> subs  = jdbcTemplate.query(sql,
                new SubjectRowMapper());

        return subs;
    }

    public Subject findById(long id) {
        return jdbcTemplate.queryForObject("select * from subject where id=?", new Object[]{
                        id
                },
                new SubjectRowMapper());
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from subject where id=?", new Object[] {
                id
        });
    }
}*/
