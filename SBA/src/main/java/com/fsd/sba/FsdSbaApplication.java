package com.fsd.sba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories("com.fsd.sba.dao")
@EntityScan("com.fsd.sba.model")
public class FsdSbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsdSbaApplication.class, args);
    }

}
