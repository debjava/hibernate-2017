package com.ddlab.rnd.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity  
@Table(name="PermanentEmployee")  
public class PermanentEmployee extends Employee {
	
	@Column(name="projectName") 
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
