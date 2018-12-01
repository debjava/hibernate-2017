package com.ddlab.rnd.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT3")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private long id;

	@Column(name = "firstName")
	private String firstName;

	/*
	 * How will you get subject information from Student table ? This is a
	 * special case for many to many. We get by joining third table
	 * student-subject3
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_SUBJECT3", joinColumns = { @JoinColumn(name = "studentId") }, inverseJoinColumns = {
			@JoinColumn(name = "subjectId") })
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
