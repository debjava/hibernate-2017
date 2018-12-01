package com.ddlab.rnd.dao.user.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.dao.AbstractCoreDAO;
import com.ddlab.rnd.dao.user.IUserDAO;
import com.ddlab.rnd.entity.user.UserEntity;

@Repository(value = "userDao")
public class UserDAOImpl extends AbstractCoreDAO<UserEntity,Long> implements IUserDAO {

	@Override
	public UserEntity getUsersById(Long id) {
		System.out.println("ZaraUserDAOImpl : getUsersById");
		return super.getById(id);
	}

	@Override
	public UserEntity getUsersByName(String name) {
		UserEntity userEntity = null;
		System.out.println("ZaraUserDAOImpl : getUsersByName");
		String hql = "FROM UserEntity user where user.userName = "+"\'"+name+"\'";
		Query query = getSession().createQuery(hql);
		List results = query.list();
		if( results != null )
			userEntity = (UserEntity) results.get(0);
		System.out.println("User List size :::"+results.size());
		System.out.println("First Value :::"+results.get(0));
		return userEntity;
		
	}
	
}
