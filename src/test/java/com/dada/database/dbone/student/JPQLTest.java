package com.dada.database.dbone.student;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentApplication.class)
class JPQLTest {
	
	@Autowired
	EntityManager em;

	@Test
	void queryTest() {
		List<Course> rs = em.createQuery("select c from Course c").getResultList();
		System.out.println(rs);
	}
	
	
	@Test
	void queryWhereTest() {
		List<Course> rs = em.createQuery("select c from Course c where c.name like '%Let'", Course.class).getResultList();
		System.out.println("Where JPQL query: "+rs);
	}
	
	


}
