package com.dada.database.dbone.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	public Student findById(int id) {
		return em.find(Student.class, id);
	}
	
	@Transactional
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z456321");
		Student student = new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
		em.persist(passport);

	}
	
	
	void retrieveStudentWithPassport() {
		Student student = em.find(Student.class, 10001L);
		logger.info("student: {}", student);
		logger.info("passport: {}", student.getPassport());//eager fetch: when fetching student, passport also fetched
		//In case of Lazy fetch, methods needs to be @Transactional to run
	}
	
	@Transactional
	public void deleteById(int id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public List<Student> findAll(){
		return em.createNamedQuery("query_get_all_students", Student.class).getResultList();//can run native sql queries too using em.createNativeQuery
		//em.createNativeQuery("select * from student");
	}
	
	
	@Transactional
	public void modifyStudentAfterPersist() {
		
	}

}
