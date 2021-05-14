package com.dada.database.dbone.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dada.database.dbone.entity.Person;

@Repository 
@Transactional //needed for merge (update) queries
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entitymanager;		//connect to db configured: h2
	
	
	public Person findById(int id) {
		return entitymanager.find(Person.class, id); //Table(Entity): Person
	}
	
	public Person update(Person person) {
		return entitymanager.merge(person);
	}
	
	public void delete(int id) {
		Person p = findById(id);
		entitymanager.remove(p);
	}
	
	//JPQL Query
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entitymanager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	

}
