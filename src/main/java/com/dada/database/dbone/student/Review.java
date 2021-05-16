package com.dada.database.dbone.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	private String rating;
	
	@Column(name = "description")
	private String desc;
	
	@ManyToOne //Eager fetching by default
	private Course course;

	public Review() {
		super();
	}

	public Review(String rating, String desc) {
		super();
		this.rating = rating;
		this.desc = desc;
	}
	
	public Review(Long id, String rating, String desc) {
		super();
		this.id = id;
		this.rating = rating;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", desc=" + desc + ", course=" + course.getId() + "]";
	}

	
	
	
	
	
	

}
