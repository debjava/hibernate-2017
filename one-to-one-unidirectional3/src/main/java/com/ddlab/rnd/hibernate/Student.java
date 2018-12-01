package com.ddlab.rnd.hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = -282016336815027846L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private int studentId;

	@Column(name = "firstName")
	private String firstName;

	/*
	 * How will you get subject from Student table ?
	 * By joining subjectId column from Student table
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subjectId")
	private Subject subject;
	
	public Student() {} //Required while getting data from database

	public Student(String firstName) {
		this.firstName = firstName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
