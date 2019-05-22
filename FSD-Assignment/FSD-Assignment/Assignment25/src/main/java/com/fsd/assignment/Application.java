package com.fsd.assignment;

import com.fsd.assignment.entity.Book;
import com.fsd.assignment.entity.Subject;
import com.fsd.assignment.service.BookService;
import com.fsd.assignment.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication

//@ComponentScan (basePackages = {"com.fsd.assignment"})
//@EnableJpaRepositories(basePackages = "ccm.fsd.assignment.dao")

public class Application implements CommandLineRunner {
/*
	@Autowired
	BookJdbcRepository bookJdbcRepository;

	@Autowired
	SubjectJdbcRespository subjectJdbcRespository;*/

    @Autowired
	DataSource dataSource;



	@Autowired
	SubjectService subjectService;

	@Autowired
	BookService bookService;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner in = new Scanner ( System.in );
		display_menu();

		switch ( in.nextInt() ) {
			case 1:
				System.out.println ( "You picked option 1" );
				Book newBook = create(new Book());
				bookService.save(newBook);
				break;
			case 2:
				System.out.println ( "You picked option 2" );
				subjectService.deleteById(Long.parseLong("1"));
				break;
			case 3:
				System.out.println ( "You picked option 3" );
				bookService.deleteById(Long.parseLong("1"));
				break;
			case 4:
				System.out.println ( "You picked option 4" );
				Optional<Book> book =bookService.findById(Long.parseLong("1"));
				System.out.println(book.toString());
				break;
			case 5:
				System.out.println ( "You picked option 5" );

				Optional<Subject> sub =subjectService.findById(Long.parseLong("1"));
				System.out.println(sub.toString());
				break;
			case 6:
				System.out.println ( "You picked option 6" );

				break;
			case 7:
				System.out.println ( "You picked option 7" );
			//	List<Subject> subs = subjectJdbcRespository.findAll();
		//		List<Subject> sortSubByTitle = subs.stream().sorted(Comparator.comparing(Subject ::getSubtitle)).collect(Collectors.toList());
			//	System.out.println(sortSubByTitle.toString());
				break;
			case 8:
				System.out.println ( "You picked option 8" );
				//List<Book> booksList = bookJdbcRepository.findAll();
			//	List<Book> sortedByPubDate = booksList.stream().sorted(Comparator.comparing(Book ::getPublishDate)).collect(Collectors.toList());
				//System.out.println(sortedByPubDate.toString());

				break;
			case 9:
				System.out.println ( "You picked option 9" );
				break;
			default:
				System.err.println ( "Unrecognized option" );
				break;
		}

	}

	public void display_menu() {
		// Display menu graphics
		System.out.println("============================");

		System.out.println("|   MENU SELECTION DEMO    |");
		System.out.println("============================");
		System.out.println("| Options:                 |");
		System.out.println("|        1. Add a Book  |");
		System.out.println("|        2. Delete a Subject |");
		System.out.println("|        3. Delete a book    |");
		System.out.println("|        4. Search for a book|");
		System.out.println("|        5. Search for a subject |");
		System.out.println("|        6. Exit |");

		System.out.println("============================");
		System.out.print ( "Select an option : " );

	}

	Book create (Book book)
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
