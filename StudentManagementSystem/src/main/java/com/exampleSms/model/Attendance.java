package com.exampleSms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String Student_Name;
	@Column
	private String Teacher_Name;
	@Column
	private int Attendance=100;
	private int Min_Required_Attendance=75;
	private int Student_Attendance;



}
