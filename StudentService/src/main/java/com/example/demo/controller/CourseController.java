package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.CoursesApi;
import com.example.demo.service.CourseService;
import com.example.models.Course;

@RestController
public class CourseController implements CoursesApi {
	
	@Autowired
	private CourseService courseService;

	@Override
	public ResponseEntity<List<Course>> coursesGet(@Valid String coursename) {
		
		List<Course> courses = courseService.getCourses();
		ResponseEntity<List<Course>> response = new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
		
		
		return response;
	}

	@Override
	public ResponseEntity<Void> coursesIdDelete(Integer id) {
		courseService.deleteCourse(id);
		
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<Course> coursesIdGet(Integer id) {
		ResponseEntity<Course> response = new ResponseEntity<Course>(courseService.getCourseById(id), HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<Void> coursesPost(@Valid Course body) {
		courseService.saveCourse(body);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}

}
