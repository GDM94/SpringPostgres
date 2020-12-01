package com.example.springPostgres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringPostgresApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringPostgresApplication.class);

	public static void main(String[] args) {
		logger.debug("Hello from Logback");
		SpringApplication.run(SpringPostgresApplication.class, args);
	}

}
