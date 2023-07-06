package com.example.StudentRegisteration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.StudentRegisteration.ds.Student;

import java.util.List;


@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {

	@Query("select s from Student s where s.name=:name")
	Student findStudentByStudentName(@Param("name") String name);
	
	@Query("select s from Student s where s.name=:name and s.id=:id")
	Student findStudentByStudentNameAndId(@Param("name") String name,@Param("id") int id);

}
