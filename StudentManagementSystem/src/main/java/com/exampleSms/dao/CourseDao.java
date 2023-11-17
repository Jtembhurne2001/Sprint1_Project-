package com.exampleSms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleSms.model.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

}
