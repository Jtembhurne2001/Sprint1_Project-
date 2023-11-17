package com.exampleSms.model;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	private String sname;
	private double fees ;
	private String CourseApplied;
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Personal_Details_id", referencedColumnName = "id")
    private PersonalDetail detail;
	*/
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public String getCourseApplied() {
		return CourseApplied;
	}
	public void setCourseApplied(String courseApplied) {
		CourseApplied = courseApplied;
	}
	
	
}
