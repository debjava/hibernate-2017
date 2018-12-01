package com.ddlab.rnd.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity  
@Table(name = "employee")  
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  
public class Employee {
	
	@Id  
	@Column(name = "id")  
	private int id;  
	  
	@Column(name = "name")  
	private String name;

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

}