package com.ddlab.rnd.hibernate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  
@DiscriminatorValue("PermanentEmployee") 
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
