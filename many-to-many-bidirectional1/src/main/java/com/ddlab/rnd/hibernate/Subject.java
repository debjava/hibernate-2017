package com.ddlab.rnd.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT3")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subjectId")
	private long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "subjects")
	private List<Student> students = new ArrayList<Student>();

	public Subject() {

	}

	public Subject(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}