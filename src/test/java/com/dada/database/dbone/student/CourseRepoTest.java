package com.dada.database.dbone.student;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentApplication.class)
class CourseRepoTest {
	
	@Autowired
	CourseRepo crepo;

	@Test
	void findByIdTest() {
		Course course = crepo.findById(101);
		assertEquals("Basics of Computer Concepts", course.getName());
	}
	
	@Test
	@DirtiesContext //roll back changes after the test. Without this annotation also happens!
	void deleteByIdTest() {
		crepo.deleteById(105);
		assertNull(crepo.findById(105));
	}
	
	
	@Test
	//@DirtiesContext
	void createCourseTest() {
		crepo.updateCourse(new Course(5, "JUnit book"));
		assertNotNull(crepo.findById(2));
	}
	
	@Test
	@DirtiesContext
	void updateCourseTest() {
		Course course = crepo.findById(101);
		course.setName("Test Skills");
		crepo.updateCourse(course);
		assertEquals("Test Skills", crepo.findById(101).getName());
	}

}
