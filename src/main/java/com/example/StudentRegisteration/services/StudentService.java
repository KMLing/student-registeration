package com.example.StudentRegisteration.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.StudentRegisteration.ds.Student;
public interface StudentService {
	
	Student create(Student student);
	void delete(Integer id);
	List<Student> read(Student student );
	Student updateStudent(Student student);
	Student findStudentById(Integer id);

}
