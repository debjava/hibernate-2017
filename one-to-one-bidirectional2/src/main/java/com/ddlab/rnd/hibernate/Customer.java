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
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -282016336815027846L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	private int customerId;

	@Column(name = "firstName")
	private String firstName;

	/*
	 * How will you get Address from Customer table ? I can not get directly as
	 * there is no relationship. 
	 * To establish relationship, I have to use mappedBy
	 */
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	private Address address;

	public int getCustomerId() {
		return customerId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
