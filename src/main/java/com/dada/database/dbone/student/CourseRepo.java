package com.dada.database.dbone.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepo {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
	
	public List<Course> findAll(){
		return em.createNamedQuery("query_get_all_courses", Course.class).getResultList();//can run native sql queries too using em.createNativeQuery
		//em.createNativeQuery("select * from course");
	}
	
	
	@Transactional
	public void modifyCourseAfterPersist() {
		Course newCourse = new Course("Mello world");
		em.persist(newCourse);
		//em.flush(); //send to db
		//em.detach(newCourse); or em.clear() to detach all entities
		newCourse.setName("Hello World"); //entity manager magic! persists this bcz its inside Transaction if flush & detach isn't run before
		//em.refresh(newCourse); //change the state of 'newCourse' to what is in db
		
		Course c1 = findById(1);
		c1.setName("Test Your C"); //updates Course 1 in db!!
		em.refresh(c1);//refreshes back to original db value
	}

	@Transactional
	public void addreviewsForCourse() {
			Course course = em.find(Course.class, 103);
			Review r1 = new Review("5", "fdghh");
			Review r2 = new Review("3", "hgdf fjkdhjkf jfk");
			
			course.addReview(r1);
			course.addReview(r2);
			
			r1.setCourse(course);
			r2.setCourse(course);
			
			em.persist(r2);
			em.persist(r1);
			logger.info("reviews for Course 103 -> {}", course.getReviews());

			//em.merge(course); //not needed
	}

}
