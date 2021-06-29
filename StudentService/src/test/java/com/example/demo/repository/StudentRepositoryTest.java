package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.entities.StudentEntity;

@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository repo;

	@Test
	public void getTop2StudentTest() {
		List<StudentEntity> findTop2ByStudentName = repo.findTop2ByStudentName("Rudra");
		assertEquals(2, findTop2ByStudentName.size());
	}

	@Test
	public void countStudentTest() {
		Long countByStudentName = repo.countByStudentName("Rudra");
		assertEquals(3L, countByStudentName);

	}

	@Test
	public void customQuery() {
		List<StudentEntity> queryByStudentName = repo.queryByStudentName("Rudra");
		assertEquals(3L, queryByStudentName.size());

	}

	@BeforeEach
	private void saveData() {
		repo.deleteAll();
		StudentEntity s1 = new StudentEntity("Rudra", 39, "group_2");
		StudentEntity s2 = new StudentEntity("Rudra", 30, "group_1");
		StudentEntity s3 = new StudentEntity("Rudra", 40, "group_3");
		List<StudentEntity> studentList = new ArrayList<StudentEntity>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		repo.saveAll(studentList);
	}

}
