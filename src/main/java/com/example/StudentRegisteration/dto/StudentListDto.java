package com.example.StudentRegisteration.dto;

import com.example.StudentRegisteration.ds.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentListDto {
    List<Student> studentList=new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
