package com.ddlab.rnd.hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT")
public class Subject implements Serializable {

	private static final long serialVersionUID = 3331340035611931999L;

	@Id
	@GeneratedValue
	@Column(name = "subjectId")
	private long id;

	@Column(name = "name")
	private String name;

	/*
	 * How will you get student information from Subject table ?
	 * By joining studentId
	 */
	@ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn(name = "studentId")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

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

}