package com.example.StudentRegisteration.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.StudentRegisteration.dao.StudentDao;
import com.example.StudentRegisteration.ds.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private  StudentDao studentDao;


	@Override
	public Student create(Student student) {
		
		return studentDao.save(student);
	}

	@Override
	public void delete(Integer id) {
		studentDao.deleteById(id);
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Student> read(Student student) {
		if(student.getName()!=null && student.getName().trim().isEmpty()) {
			student.setName(null);
		}
		List<Student> list=new ArrayList();
		
		if(student.getId() != null && student.getName() == null && student.getNrc() == null 
				&& student.getPassword()==null && student.getPhoneNumber()==null && student.getRole()==null ) {
			
		
			list.add(studentDao.findById(student.getId()).get());
			return list ;
		}
		else if(student.getId() == null && student.getName() != null && student.getNrc() == null 
				&& student.getPassword()==null && student.getPhoneNumber()==null && student.getRole()==null ){
			list.add(studentDao.findStudentByStudentName(student.getName()));
			return  list;
		}
		else if(student.getId() != null && student.getName() != null && student.getNrc() == null 
				&& student.getPassword()==null && student.getPhoneNumber()==null && student.getRole()==null ) {
			
			
			list.add(studentDao.findStudentByStudentNameAndId(student.getName(),student.getId()));
			return  list;
		}
		else
			return studentDao.findAll();
	}

	

	@Override
	public Student findStudentById(Integer id) {
		
		return studentDao.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		Student existStudent=studentDao.findById(student.getId()).get();
		existStudent.setName(student.getName());
		existStudent.setNrc(student.getNrc());
		existStudent.setPassword(student.getPassword());
		existStudent.setPhoneNumber(student.getPhoneNumber());
		existStudent.setRole(student.getRole());
		return studentDao.save(existStudent);
	}


	



}
