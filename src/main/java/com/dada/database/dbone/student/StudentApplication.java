package com.dada.database.dbone.student;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	CourseRepo courseRepo;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Course id: 101-> {}", courseRepo.findById(101));
		logger.info("Add course id: 108-> {}", courseRepo.updateCourse(new Course(108, "Let us C")));
		courseRepo.deleteById(103);
	}

}
