package com.capgemini.restexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.restexample.dao.CourseRepository;
import com.capgemini.restexample.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository repository;	
	
	@Override
	public Course getCourseById(Integer courseId) {
		Optional<Course> optCourse = repository.findById(courseId);
		if(optCourse.isPresent()) {
			return optCourse.get();
		}
		return null;
	}

	@Override
	public List<Course> getCourses() {
		
		return (List<Course>) repository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		
		return repository.save(course);
	}

	@Override
	public void deleteCourse(Integer courseId) {
		repository.deleteById(courseId);
	}

	@Override
	public Course updateCourse(Course course, Integer courseId) {
		Optional<Course> courseData = repository.findById(courseId);
		if (courseData.isPresent()) {
			Course _course = courseData.get();
			_course.setCourseId(course.getCourseId());
			_course.setCourseName(course.getCourseName());
			return repository.save(_course);
		}else {
				return null;
			}
	}

}
