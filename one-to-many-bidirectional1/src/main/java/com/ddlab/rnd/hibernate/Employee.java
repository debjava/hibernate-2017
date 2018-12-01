package com.ddlab.rnd.hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="EMP")
public class Employee {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long employeeId;
     
    @Column(name="firstname")
    private String firstname;
 
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
     
    public Employee() {
         
    }
     
    public Employee(String firstname) {
        this.firstname = firstname;
    }

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
 
}   