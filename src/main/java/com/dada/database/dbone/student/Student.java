package com.dada.database.dbone.student;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pass_id")
	private Passport passport;
	
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", 
	joinColumns = @JoinColumn(name = "STUDENT_ID"),
	inverseJoinColumns = @JoinColumn( name ="COURSE_ID"))
	private List<Course> courses = new ArrayList<>();

	public Student() {
		super();
	}
	
	public Student(String name) {
		super();
		this.name = name;
	}

	public Student(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course c) {
		this.courses.add(c);
	}
	
	public void removeCourse(Course c) {
		this.courses.remove(c);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + ", courses=" + courses + "]";
	}

	

	
	
	
	
	
	

}
