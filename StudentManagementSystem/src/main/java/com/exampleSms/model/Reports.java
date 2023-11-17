package com.exampleSms.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Reports {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int report_id;
	@Column
	private String Course_name;
	@Column
	private String Test_name;
	@Column
	private double Student_Marks;
	@Column
	private String Duration;
	@Column
	private int Result;
	
	@OneToOne
	@OneToMany
	@JsonIgnoreProperties("Report")
	private List<Student> students;
}
