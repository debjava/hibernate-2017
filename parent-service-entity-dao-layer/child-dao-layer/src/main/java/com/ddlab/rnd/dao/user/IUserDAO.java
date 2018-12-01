package com.ddlab.rnd.dao.user;

import com.ddlab.rnd.dao.ICoreDAO;
import com.ddlab.rnd.entity.user.UserEntity;

public interface IUserDAO extends ICoreDAO<UserEntity,Long> {
	
	public UserEntity getUsersById(Long id);
	
	public UserEntity getUsersByName(String name);

}
