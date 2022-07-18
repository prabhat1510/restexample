package com.capgemini.restexample.service;

import java.util.List;

import com.capgemini.restexample.entity.Course;

public interface CourseService {
	//Retrieve
	public Course getCourseById(Integer courseId);
	//Retrieve
	public List<Course> getCourses();
	//Create
	public Course addCourse(Course course);
	//Delete
	public void deleteCourse(Integer studnetId);
	//Update
	public Course updateCourse(Course course, Integer courseId);
	
}
