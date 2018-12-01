package com.ddlab.rnd.spring.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ddlab.rnd.entity.user.UserEntity;
import com.ddlab.rnd.service.user.IUserService;

//@Repository(value = "userDao")
public class CustomUserDAO implements UserDetailsService {
	
//	@Autowired
//    @Qualifier("userService")
//	IUserService userService;
	
	@Autowired
    @Qualifier("userService")
	IUserService userService;
	
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
//		System.out.println("userService----------->"+userService);
//		userService.getAll();
//		System.out.println("Current user Name :::"+userName);
		
		try {
			UserEntity user1 = userService.getUserByUserName(userName);
			System.out.println("Logged in User :::"+user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		try {
//			System.out.println("1----------->"+SecurityContextHolder.getContext().getAuthentication());
//			Object obj = SecurityContextHolder.getContext().getAuthentication().getCredentials();
//			System.out.println("Object ::::"+obj);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		
		List<GrantedAuthority> gList = new ArrayList<GrantedAuthority>();
		
//		GrantedAuthority ga1 = new GrantedAuthorityImpl("TMP_BAR");
		GrantedAuthority ga1 = new SimpleGrantedAuthority("ROLE_USER");
		gList.add(ga1);
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		String password = "miki";
		
		UserDetails user = new User(userName, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, gList);
		
//		UserDetails user = new User(userName, "deba", enabled, true, true, true, gList);
		
		
		return user;
		
//		return null;
	}
	
	

}
