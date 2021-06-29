package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.repository.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	List<StudentEntity> findTop2ByStudentName(String studentName);
	Long countByStudentName(String studentName);
	
	@Query(value = "select s from StudentEntity s where studentName = :studentName ")
	List<StudentEntity> queryByStudentName(@Param(value = "studentName") String studentName);

}
