package com.ddlab.rnd.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ddlab.rnd.entity.IEntity;

@Entity
@Table(name="zara_userdetails")
public class UserDetailsEntity implements IEntity {

	private static final long serialVersionUID = 7698286130450472294L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="authority")
	private String authority;
	
	@ManyToOne
    @JoinColumn(name="userid")
    private UserEntity zaraUser;
	
	public UserDetailsEntity() {
		
	}

	public UserDetailsEntity(String username, String authority, UserEntity zaraUser) {
		super();
		this.username = username;
		this.authority = authority;
		this.zaraUser = zaraUser;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public UserEntity getZaraUser() {
		return zaraUser;
	}
	
	
	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setZaraUser(UserEntity zaraUser) {
		this.zaraUser = zaraUser;
	}


	@Override
	public String toString() {
		return "ZaraUserDetails [id=" + id + ", username=" + username
				+ ", authority=" + authority + "]";
	}

}
