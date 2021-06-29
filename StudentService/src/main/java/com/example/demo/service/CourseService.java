package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.entities.CourseEntity;
import com.example.demo.utility.StudentUtility;
import com.example.models.Course;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseDAO;
	
	public List<Course> getCourses(){
		List<CourseEntity> courseEntities = courseDAO.findAll();
		List<Course> courses=courseEntities.stream().map(StudentUtility::toCourseModel).collect(Collectors.toList());
		return courses;
	}
	
	public void saveCourse(Course course) {
		courseDAO.save(StudentUtility.toCourseEntity(course));
	}
	public void deleteCourse(Integer id) {
		courseDAO.deleteById(id);
	}
	
	public Course getCourseById(Integer id) {
		CourseEntity course = courseDAO.getOne(id);
		return StudentUtility.toCourseModel(course);
	}
	
	
}
