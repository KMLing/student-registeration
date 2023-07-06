package com.example.StudentRegisteration.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.StudentRegisteration.ds.Student;
import com.example.StudentRegisteration.dto.StudentListDto;
import com.example.StudentRegisteration.services.StudentService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
	

	private final StudentService studentService;
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	@GetMapping("/")
	public String home(){
		return "home";
	}
	
	
	
	  @GetMapping("/login")
	    public String login(){
	        return "login";
	    }
	    @GetMapping("/login-error")
	    public String loginError(Model model){
	        model.addAttribute("loginError",true);
	        return "login";
	    }
	
	   
	
	

	@GetMapping("/student")
	public String NewStudent(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return "StudentForm";
		
	}
	@PostMapping("/student")
	public String process(Student student, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "StudentForm";
		}
		studentService.create(student);
		return "redirect:/";
		
	}
	
	
	
	@GetMapping("/all")
    public String showStudent(Model model){
		Student student=new Student();
        model.addAttribute("search",student);
      
        model.addAttribute("students",studentService.read(student));

        return "studentDataTableWithTmLoop";
    }
	@PostMapping("/all")
	public String showStudent(@ModelAttribute("search")Student student,Model model) {
		
		System.out.println("from controller"+student.toString());
		
		model.addAttribute("students",studentService.read(student));

		return "studentDataTableWithTmLoop";
		
	}
	

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id){
		studentService.delete(id);
		return "redirect:/all";
	}
	
	@GetMapping("/update/{id}")
	public String updateStudent(@PathVariable("id")Integer id,Model model) {
		model.addAttribute("student",studentService.findStudentById(id));
		return "UpdateForm";
	}
	@PostMapping("/update/{id}")
	public String updateStudent(@ModelAttribute("student")Student student) {
		
		System.out.println(student.toString());
		
		studentService.updateStudent(student);
		return "redirect:/all";
		
	}




}
