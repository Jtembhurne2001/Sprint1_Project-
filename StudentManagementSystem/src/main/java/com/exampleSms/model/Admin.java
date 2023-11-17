package com.exampleSms.model;
//import java.util.ArrayList;
//import java.util.List;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double fee;
	private String addcourse;
	private String Username;
	private String Password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getAddcourse() {
		return addcourse;
	}
	public void setAddcourse(String addcourse) {
		this.addcourse = addcourse;
	}
	/*public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}*/
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	// @OneToMany(cascade = CascadeType.ALL)
	  //  @JoinColumn(name = "Course_id", referencedColumnName = "id")
	    //List < Course > course = new ArrayList < > ();
	 public Admin() {

	    }

	
	
}