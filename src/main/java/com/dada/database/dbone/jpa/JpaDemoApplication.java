package com.dada.database.dbone.jpa;

import org.slf4j.LoggerFactory;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person dan = repo.findById(10001);
		logger.info("findByID: 10001-> {} ", dan);
		logger.info("insert Person jane -> {}", repo.update(new Person("Jane", "London", new Date())));
		
		dan.setName("Daniel");
		logger.info("insert Person jane -> {}", repo.update(dan));
		
		repo.delete(1);
		logger.info("All Employees: {}", repo.findAll());
	}

}
