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
@Table(name = "STUDENT")
public class StudentEntity {

	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer studentId;

	@Column(name="STUDENT_NAME")
	private String studentName;

	@Column(name = "STUDENT_AGE")
	private Integer age;

	@Column(name = "GROUP_ID")
	private String groupId;
	
	
	@ManyToMany
    @JoinTable(
    		name = "STUDENT_COURSE",
    		joinColumns = @JoinColumn(name = "STUDENT_ID"),
    		inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    		)
	private Set<CourseEntity> courses;

	
	
	public StudentEntity() {
		super();
	}

	public StudentEntity(String name, int age, String groupId) {
		this.studentName=name;
		this.age=age;
		this.groupId=groupId;
		
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Set<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseEntity> courses) {
		this.courses = courses;
	}

			
	
	

}