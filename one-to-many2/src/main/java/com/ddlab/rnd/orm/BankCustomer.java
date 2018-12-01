package com.ddlab.rnd.orm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Customer has multiple accounts
 */
@Entity
@Table(name="BankCustomer")
public class BankCustomer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="custId")
	private long custId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="actId")
	private long actId;
	
//	@OneToMany(mappedBy="bankCustomer")
	
	
	
	
	public long getActId() {
		return actId;
	}

	public void setActId(long actId) {
		this.actId = actId;
	}

	@OneToMany
	@JoinTable(name = "BankCustomer", joinColumns = @JoinColumn(name = "custId"), inverseJoinColumns = @JoinColumn(name = "actId"))
    private Set<BankAccount> accounts;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<BankAccount> accounts) {
		this.accounts = accounts;
	}

}
