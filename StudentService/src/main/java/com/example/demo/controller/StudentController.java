
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.StudentApi;
import com.example.demo.service.StudentService;
import com.example.models.Course;
import com.example.models.Student;





@RestController
public class StudentController implements StudentApi{
	
	
	private static Logger logger = LoggerFactory.getLogger(StudentController.class);

	
	@Autowired
	private StudentService studentService;
	

	

	@Override
	public ResponseEntity<Void> studentPost(@Valid Student body) {
		studentService.saveStudent(body);
		return null;
	}

	@Override
	public ResponseEntity<Void> studentIdDelete(Integer id) {
		studentService.deleteStudent(id);
		return null;
	}

	@Override
	public ResponseEntity<Student> studentIdGet(Integer id) {
		
		Student student = studentService.getById(id);
		if(student!=null) {
			logger.info("Found student with id {}", id);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		else {
			logger.info("Could not find student with id {}", id);
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	

	

	@Override
	public ResponseEntity<List<Course>> studentStudentIdCoursesGet(Integer studentId) {
		ResponseEntity<List<Course>> responseEntity = null;
		List<Course> student = studentService.getByStudent(studentId);
		if(student!=null && !student.isEmpty())
			responseEntity = new ResponseEntity<List<Course>>(student, HttpStatus.OK);
		else
			responseEntity = new ResponseEntity<List<Course>>(student, HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@Override
	public ResponseEntity<Void> studentStudentIdCoursesPost(Integer studentId, @Valid List<Course> body) {
		
		studentService.enrollStudent(studentId, body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Student>> studentGet(@Valid String studentname) {
		
		List<Student> allStudent = studentService.getAllStudent();
		ResponseEntity<List<Student>> response=new ResponseEntity<List<Student>>(allStudent, HttpStatus.OK);
		return response;
	}

	
	
	
	

}
