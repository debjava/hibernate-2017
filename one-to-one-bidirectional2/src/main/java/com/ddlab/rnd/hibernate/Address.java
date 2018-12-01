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
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = -6494554948746566564L;

	@Id
	@Column(name = "addressId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	@Column(name = "city")
	private String city;

	/*
	 * How will you get Customer from Address table ? I can get by joining
	 * customerId column in both the tables.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Address() {

	}

	public Address(String city) {
		this.city = city;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
