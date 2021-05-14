package com.dada.database.dbone.student;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepo {
	
	@Autowired
	EntityManager em;
	
	public Course findById(int id) {
		return em.find(Course.class, id);
	}

}
