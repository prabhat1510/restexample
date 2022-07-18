package com.capgemini.restexample.service;

import java.util.List;

import com.capgemini.restexample.entity.Student;

public interface StudentService {
	//Retrieve
	public Student getStudentById(Integer studentId);
	//Retrieve
	public List<Student> getStudents();
	//Create
	public Student addStudent(Student student);
	//Delete
	public void deleteStudent(Integer studnetId);
	//Update
	public Student updateStudent(Student student, Integer studentId);
	
}
