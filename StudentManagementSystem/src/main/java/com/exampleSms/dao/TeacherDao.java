package com.exampleSms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleSms.model.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}
