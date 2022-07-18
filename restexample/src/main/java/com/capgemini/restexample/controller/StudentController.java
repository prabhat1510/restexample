package com.capgemini.restexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.restexample.entity.Student;
import com.capgemini.restexample.service.StudentService;

@RestController
public class StudentController {
		@Autowired
		private StudentService service;
		//Retrieve
		@GetMapping("/student/{studentId}")
		public Student getStudentById(@PathVariable("studentId") Integer studentId) {
			return service.getStudentById(studentId);
		}
		//Retrieve
		@GetMapping("/students")
		public List<Student> getStudents(){
			return service.getStudents();
		}
		//Create
		@PostMapping("/addstudent")
		public Student addStudent(@RequestBody Student student){
			return service.addStudent(student);
		}
		//Delete
		@DeleteMapping("/deletestudent/{id}")
		public void deleteStudent(@PathVariable("id") Integer studentId){
			service.deleteStudent(studentId);
		}
		//Update
		@PutMapping("/updatestudent/{id}")
		public Student updateStudent(@RequestBody Student student, @PathVariable("id") Integer studentId){
			Student studentData = service.updateStudent(student, studentId);
			return studentData;
		}
}
