package com.ddlab.rnd.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "userInfo")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq_gen")
	@SequenceGenerator(name = "my_seq_gen", sequenceName = "userInfoSeq") // sequenceName
																			// is
																			// the
																			// actual
																			// oracle
																			// sequence
	private int id;

	@Column(name = "name")
	private String name;

	public UserInfo(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
