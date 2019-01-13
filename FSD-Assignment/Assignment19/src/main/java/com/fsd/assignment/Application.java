package com.fsd.assignment;

import com.fsd.assignment.dao.BookJpaRepository;
import com.fsd.assignment.dao.SubjectJpaRepository;
import com.fsd.assignment.entity.Book;
import com.fsd.assignment.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication

//@ComponentScan (basePackages = {"com.fsd.assignment"})
//@EnableJpaRepositories(basePackages = "ccm.fsd.assignment.dao")

public class Application  {

    @Autowired
	DataSource dataSource;



	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}



}
