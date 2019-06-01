/*
package com.fsd.assignment.test;

import com.fsd.assignment.dao.BookJpaRepository;
import com.fsd.assignment.entity.Book;
import com.fsd.assignment.entity.Subject;
import com.fsd.assignment.service.BookService;
import com.fsd.assignment.service.SubjectService;
import com.fsd.assignment.service.impl.BookServiceImpl;
import com.fsd.assignment.service.impl.SubjectServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@DataJpaTest
public class jpaIntegrationTest {

    @TestConfiguration
    static class BookServiceImplTestContextConfiguration {

        @Bean
        public BookService bookService() {
            return new BookServiceImpl();
        }

        @Bean
        public SubjectService subjectService() {
            return new SubjectServiceImpl();
        }
    }

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    BookJpaRepository bookJpaRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Book book = new Book();
        Subject s = new Subject();
        s.setSubjectId(2);
        s.setSubtitle("New Subject");
        s.setDurationInHours(4);

        book.setBookId(6);
        book.setTitle("New book");
        book.setPrice(100.00);
        book.setVolume(5);
        book.setPublishDate(LocalDate.now());
        book.setSubject(s);
        entityManager.persist(book);
        entityManager.flush();

        // when
        Book found = bookJpaRepository.findByBookId(book.getBookId()).get();

        // then
        assertThat(found.getTitle())
                .isEqualTo(book.getTitle());
    }
}
*/
