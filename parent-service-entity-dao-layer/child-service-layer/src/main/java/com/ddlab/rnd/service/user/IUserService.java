package com.ddlab.rnd.service.user;

import java.util.List;

import com.ddlab.rnd.entity.user.UserEntity;
import com.ddlab.rnd.entity.user.UserDetailsEntity;

public interface IUserService {
	
	public List<UserEntity> getAllFilteredUsers(List<Long> ids);
	
	public UserEntity getUserByUserName(String name);
	
	public UserDetailsEntity getUserDetailsByUserName(String name);

}
