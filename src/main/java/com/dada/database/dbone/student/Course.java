package com.dada.database.dbone.student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
//@Table(name="table_name")
@NamedQuery(name= "query_get_all_courses", query="select c from Course c")
public class Course {
	
	@Id
	@GeneratedValue
	int id;
	
	//@Column(name="column_name", unique = false, nullable = false) // wo't allow to persist nll values to name
	String name;
	
	
	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;
	
	@CreationTimestamp
	private LocalDateTime creationDate;
	
	
	@OneToMany(mappedBy = "course") //@OneToMany lazy fetch by default
	List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();
	
	public Course() {
		super();
	}
	
	public Course(String name) {
		super();
		this.name = name;
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
	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
	public void addStudent(Student s) {
		this.students.add(s);
	}
	
	public void removeStudent(Student s) {
		this.students.remove(s);
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", reviews=" + reviews + ", students=" + students + "]";
	}

	

	
	
}
