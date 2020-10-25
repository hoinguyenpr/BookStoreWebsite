package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	public Users create(Users user) {
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		return super.update(user);
	}

	@Override
	public Users get(Object userID) {
		return super.find(Users.class, userID);
	}
	

	@Override
	public void delete(Object userID) {
		super.delete(Users.class, userID);
	}
	
	public Users findByEmail(String email) {
		List<Users> lUsers = super.findWithNamedQuery("Users.findByEmail", "email", email);
		
		if(lUsers != null && lUsers.size() > 0) {
			return lUsers.get(0);
		}
		
		return null;
	}

	@Override
	public List<Users> listAll() {
		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Users.countAll");
	}
	
	
	
}
