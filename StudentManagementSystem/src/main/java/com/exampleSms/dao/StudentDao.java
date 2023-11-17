package com.exampleSms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleSms.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{

}
