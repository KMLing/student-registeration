package com.example.StudentRegisteration.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentRegisteration.ds.Student;
import com.example.StudentRegisteration.dto.StudentListDto;
import com.example.StudentRegisteration.services.StudentService;
import com.google.gson.Gson;

@RestController
public class DataController {


	private final StudentService studentService;
	public DataController(StudentService studentService) {
		this.studentService = studentService;
	}
	@GetMapping("/table")
	public Object dataTable(Student student, Model model) {

		StudentListDto studentListDto=new StudentListDto();
		Gson json=new Gson();
		studentListDto.setStudentList(studentService.read(student));
		return json.toJson(studentListDto.getStudentList());

	}

}
