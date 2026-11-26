package com.capge.DemoHib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {
  
	@Id
	private int id;  
	@Column(name="f_name")
	private String firstName;
	private String lastName;  
	  
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}  
	public String getFirstName() {  
	    return firstName;  
	}  
	public void setFirstName(String firstName) {  
	    this.firstName = firstName;  
	}  
	public String getLastName() {  
	    return lastName;  
	}  
	public void setLastName(String lastName) {  
	    this.lastName = lastName;  
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}  
	  
	  
	}  

