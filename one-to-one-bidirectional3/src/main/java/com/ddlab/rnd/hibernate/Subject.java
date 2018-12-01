package com.ddlab.rnd.hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

	private static final long serialVersionUID = -6494554948746566564L;

	@Id
	@Column(name = "subjectId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;

	@Column(name = "name")
	private String name;
	
	/*
	 * How will you get Student from Subject
	 * By using mappedBy as Subject does not direct relationship
	 */
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "subject")
	private Student student;
	
	public Subject() {} //Required while getting data from database

	public Subject(String name) {
		this.name = name;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
