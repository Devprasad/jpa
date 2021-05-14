package com.dada.database.dbone.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	int id;
	String name;
	
	public Course() {
		super();
	}
	
	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
}
