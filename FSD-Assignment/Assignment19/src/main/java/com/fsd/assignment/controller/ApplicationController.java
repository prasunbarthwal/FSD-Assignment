package com.fsd.assignment.controller;

import com.fsd.assignment.dao.BookJpaRepository;
import com.fsd.assignment.dao.SubjectJpaRepository;
import com.fsd.assignment.entity.Book;
import com.fsd.assignment.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class ApplicationController {
    @Autowired
    SubjectJpaRepository subjectJpaRepository;

    @Autowired
    BookJpaRepository bookJpaRepository;

    @RequestMapping("/")
    public String welcome() {

        return "index";
    }



    @RequestMapping(value = "/search_title", method = RequestMethod.POST)
    public String searchBookByTitle(  Book book , Model model) {
       // Book newBook = create(new Book());
        Book bookSearch =bookJpaRepository.findBookByTitle(book.getTitle());
        model.addAttribute("bookSearch", bookSearch);

        return  "success";
    }
    @RequestMapping(value = "/search_duration",method = RequestMethod.POST)
    public String searchSubByDuration(Subject sub , Model model) {
       Subject subSearch = subjectJpaRepository.findByDurationInHours(sub.getDurationInHours());
        model.addAttribute("subSearch", subSearch);

        return  "success";
    }
    @RequestMapping("/add_book")
    public String addBook(Model model) {
        Book newBook = create(new Book());
        bookJpaRepository.save(newBook);
        return "success";
    }

    @RequestMapping("/del_sub")
    public String delSubject(Model model) {
        subjectJpaRepository.deleteById(Long.parseLong("1"));
        return "success";
    }

    @RequestMapping("/del_book")
    public String delBook(Model model) {
        bookJpaRepository.deleteById(Long.parseLong("1"));
        return "success";
    }

    @RequestMapping("/search_sub")
    public String seachSubject(Model model) {
        Optional<Subject> sub =subjectJpaRepository.findById(Long.parseLong("1"));
        model.addAttribute("sub", sub);
        return "success";
    }

    @RequestMapping("/search_book")
    public String searchBook(Model model) {
        Optional<Book> book =bookJpaRepository.findById(Long.parseLong("1"));
        model.addAttribute("book", book);
        return "success";
    }


  private static Book create (Book book)
    {
        Subject s = new Subject();
        s.setSubjectId(2);
        s.setSubtitle("New Subject");
        s.setDurationInHours(4);

        book.setBookId(3);
        book.setTitle("New book");
        book.setPrice(100.00);
        book.setVolume(5);
        book.setPublishDate(LocalDate.now());
        book.setSubject(s);

        return book;
    }
}
