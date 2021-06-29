package com.example.demo.repository.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "COURSE")
public class CourseEntity {

	@Id
	@Column(name = "COURSE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer courseId;

	@Column(name = "COURSE_NAME")
	private String courseName;
	
	@Column(name = "COURSE_FEE")
	private Integer courseFee;
	
	
	
    
    @ManyToMany(mappedBy = "courses")
	Set<StudentEntity> enrolledStudent;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	
	public Set<StudentEntity> getEnrolledStudent() {
		return enrolledStudent;
	}

	public void setEnrolledStudent(Set<StudentEntity> enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}

	public Integer getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Integer courseFee) {
		this.courseFee = courseFee;
	}


	
		
	

}