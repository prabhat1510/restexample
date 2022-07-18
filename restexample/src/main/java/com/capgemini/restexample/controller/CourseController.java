package com.capgemini.restexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.restexample.entity.Course;
import com.capgemini.restexample.service.CourseService;

@RestController
public class CourseController {
		//implement different methods
	@Autowired
	private CourseService service;
	//Retrieve
	@GetMapping("/course/{courseId}")
	public Course getCourseById(@PathVariable("courseId") Integer courseId) {
		return service.getCourseById(courseId);
	}
}
