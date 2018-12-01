package com.ddlab.rnd.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity  
@Table(name="PermanentEmployee")  
@PrimaryKeyJoinColumn(name="ID")  
public class PermanentEmployee extends Employee {
	
	@Column(name="salary")    
	private float salary;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	} 

}
