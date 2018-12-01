package com.ddlab.rnd.entity.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ddlab.rnd.entity.IEntity;

@Entity
@Table(name="zara_user")
public class UserEntity implements IEntity {

	private static final long serialVersionUID = -7534699551344892730L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private long userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="accountNonExpired")
	private boolean accountNonExpired;
	
	@Column(name="credentialsNonExpired")
	private boolean credentialsNonExpired;
	
	@Column(name="accountNonLocked")
	private boolean accountNonLocked;
	
	
	@OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="userid")
    private Set<UserDetailsEntity> zaraUserDetails;

	public UserEntity() {
		
	}

	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}


	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}


	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}


	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}


	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}


	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	public Set<UserDetailsEntity> getZaraUserDetails() {
		return zaraUserDetails;
	}


	public void setZaraUserDetails(Set<UserDetailsEntity> zaraUserDetails) {
		this.zaraUserDetails = zaraUserDetails;
	}


	@Override
	public String toString() {
		return "ZaraUser [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", enabled=" + enabled
				+ ", accountNonExpired=" + accountNonExpired
				+ ", credentialsNonExpired=" + credentialsNonExpired
				+ ", accountNonLocked=" + accountNonLocked
				+ ", zaraUserDetails=" + zaraUserDetails + "]";
	}

	@Override
	public long getId() {
		return this.userId;
	}

	@Override
	public void setId(long id) {
		this.userId = id;
		
	}

}
