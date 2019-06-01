/*
package com.fsd.assignment.test;

import com.fsd.assignment.dao.BookJpaRepository;
import com.fsd.assignment.dao.SubjectJpaRepository;
import com.fsd.assignment.entity.Book;
import com.fsd.assignment.entity.Subject;
import com.fsd.assignment.service.BookService;
import com.fsd.assignment.service.SubjectService;
import com.fsd.assignment.service.impl.BookServiceImpl;
import com.fsd.assignment.service.impl.SubjectServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)

public class ServiceImplIntegrationTest {

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
    private BookService bookService;

    @Autowired
    private SubjectService subjectService;

    @MockBean
    private BookJpaRepository bookJpaRepository;

    @MockBean
    private SubjectJpaRepository subjectJpaRepository;

    @Before
    public void setUp() {
        Book book = new Book();
        Subject s = new Subject();
        s.setSubjectId(2);
        s.setSubtitle("New Subject");
        s.setDurationInHours(4);

        book.setBookId(1);
        book.setTitle("New book");
        book.setPrice(100.00);
        book.setVolume(5);
        book.setPublishDate(LocalDate.now());
        book.setSubject(s);
//        System.out.println("book" +Optional.of(book));


        Mockito.when(bookJpaRepository.findByBookId(book.getBookId()))
                .thenReturn(Optional.of(book));
        Mockito.when(subjectJpaRepository.findBySubject(s.getSubjectId()))
                .thenReturn(Optional.of(s));
    }

    @Test
    public void whenValidId_thenBookShouldBeFound() {
        long id = 1;
      Optional<Book> book = bookService.findById(id);

      System.out.println("book");

       assertThat(book.get().getBookId())
               .isEqualTo(id);
    }
    @Test
    public void whenValidId_thenSubjectShouldBeFound() {
        long id = 2;
      Optional<Subject> subject = subjectService.findById(id);

      System.out.println("book");

       assertThat(subject.get().getSubjectId())
               .isEqualTo(id);
    }

}
*/
