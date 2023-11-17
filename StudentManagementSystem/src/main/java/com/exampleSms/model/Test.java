package com.exampleSms.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Test {
	@Id
	@GeneratedValue
	private int test_id;
	private String test_name;
	private int min_marks;
	private int out_off ;
	private int stu_marks ;
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	public int getMin_marks() {
		return min_marks;
	}
	public void setMin_marks(int min_marks) {
		this.min_marks = min_marks;
	}
	public int getOut_off() {
		return out_off;
	}
	public void setOut_off(int out_off) {
		this.out_off = out_off;
	}
	public int getStu_marks() {
		return stu_marks;
	}
	public void setStu_marks(int stu_marks) {
		this.stu_marks = stu_marks;
	}
	

}
