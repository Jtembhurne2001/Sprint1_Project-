package com.exampleSms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleSms.model.Attendance;

public interface AttendanceDao extends JpaRepository<Attendance, Integer>{

	List<Attendance> findBydeptStudent_Name(String student_Name);

}
