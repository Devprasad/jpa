package com.dada.database.dbone.student;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepo {
	
	@Autowired
	EntityManager em;
	
	public Course findById(int id) {
		return em.find(Course.class, id);
	}
	
	@Transactional
	public Course updateCourse(Course course) {
		if(course.getId() == 0) {
			em.persist(course);
		}
		else {
			return em.merge(course);
		}
		return course;
	}
	
	@Transactional
	public void deleteById(int id) {
		Course course = findById(id);
		em.remove(course);
	}

}
