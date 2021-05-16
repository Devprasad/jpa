package com.dada.database.dbone.student;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentApplication.class)
class StudentRepoTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepo srepo;
	
	@Autowired
	EntityManager em;

	@Test
	void retrieveStudentWithPassportTest() {
		Student student = em.find(Student.class, 10001L);
		logger.info("student: {}", student);
		logger.info("passport: {}", student.getPassport());//eager fetch: when fetching student, passport also fetched
		//In case of Lazy fetch, methods needs to be @Transactional to run
	}
	
	@Test
	@Transactional
	void retrieveStudentWithPassportTransactionalTest() {
		Student student = em.find(Student.class, 10001L);
		logger.info("student: {}", student);
		logger.info("passport: {}", student.getPassport());//
	}
	
	@Test
	@Transactional //flows to calling method
	void retrieveStudentWithPassportTransFlowTest() {
		srepo.retrieveStudentWithPassport();
	}
	
	@Test
	@Transactional //flows to calling method
	void retrievePassportWithStudentTest() {
		Passport passport = em.find(Passport.class, 13L);
		logger.info("==passport: {}", passport);
		logger.info("==student: {}", passport.getStudent());
	}
	


}
