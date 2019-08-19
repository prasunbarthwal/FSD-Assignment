package com.fsd.fsdcapsule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories("com.fsd.fsdcapsule.dao")
@EntityScan("com.fsd.fsdcapsule.model")
public class FsdcapsuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsdcapsuleApplication.class, args);
    }

}
