package com.capgemini.restexample.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.restexample.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>{

}
