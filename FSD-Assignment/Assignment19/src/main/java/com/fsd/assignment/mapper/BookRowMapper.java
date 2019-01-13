package com.fsd.assignment.mapper;

import com.fsd.assignment.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setBookId(rs.getInt("ID"));
        book.setPrice(rs.getDouble("PRICE"));
        book.setTitle(rs.getString("TITLE"));
        book.setVolume(rs.getInt("VOLUME"));
        book.setPublishDate(rs.getDate("PUB_DATE").toLocalDate());


        return book;
    }
}
