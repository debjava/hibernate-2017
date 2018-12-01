package com.ddlab.rnd.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	private static final long serialVersionUID = 8345128974931566292L;

	@Id
	@GeneratedValue
	@Column(name = "studentId")
	private long id;

	@Column(name = "firstName")
	private String firstName;

	/*
	 * How will you get subjects from Student table
	 * By using mappedBy as there is no direct relationship.
	 * Student does not maintain relations, it is owned by Subject.
	 * Subject class has a reference to student variable
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Subject> subjects = new ArrayList<Subject>();

	public Student() {
	}

	public Student(String firstName) {
		this.firstName = firstName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}
