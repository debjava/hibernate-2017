package com.ddlab.rnd.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.dao.user.IUserDAO;
import com.ddlab.rnd.entity.user.UserDetailsEntity;
import com.ddlab.rnd.entity.user.UserEntity;
import com.ddlab.rnd.service.AbstractBasicService;
import com.ddlab.rnd.service.user.IUserService;

@Service(value = "userService")
public class UserServiceImpl extends AbstractBasicService<UserEntity, Long, IUserDAO> implements IUserService {

	@Autowired
    @Qualifier("userDao")
	IUserDAO userDAO;
	
	@Override
	public IUserDAO getDao() {
		return userDAO;
	}
	
	@Override
	public List<UserEntity> getAllFilteredUsers(List<Long> ids) {
		return null;
	}

	@Override
	public UserEntity getUserByUserName(String name) {
		return getDao().getUsersByName(name);
	}

	@Override
	public UserDetailsEntity getUserDetailsByUserName(String name) {
		return null;
	}

}
