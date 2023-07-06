package com.example.StudentRegisteration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.example.StudentRegisteration.*")
public class StudentRegisterationApplication {
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(StudentRegisterationApplication.class, args);

	}
	
	

}
