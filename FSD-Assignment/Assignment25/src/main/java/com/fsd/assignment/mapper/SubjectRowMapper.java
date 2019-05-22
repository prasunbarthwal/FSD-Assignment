package com.fsd.assignment.mapper;

import com.fsd.assignment.entity.Book;
import com.fsd.assignment.entity.Subject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectRowMapper implements RowMapper<Subject> {
    @Override
    public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subject subject = new Subject();

        subject.setSubjectId(rs.getLong("ID"));
        subject.setSubtitle(rs.getString("SUB_TITLE"));
        subject.setDurationInHours(rs.getInt("DURATION_IN_HRS"));
        //subject.setBook((Book)rs.getObject("book_id"));

        return subject;
    }
}
