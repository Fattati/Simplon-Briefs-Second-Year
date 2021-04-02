package com.reservationapp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reservationapp.dao.UserDAO;
import com.reservationapp.model.User;
import com.reservationapp.model.UserCredential;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//save user
	@Override
	public void save(User user) {
		currentSession().save(user);
		
	}
	
	//update user
	@Override
	public void update(User User) {
		currentSession().update(User);
		
	}
	
	//search for a user
	@Override
	public User get(Long id) {
		return (User)currentSession().get(User.class, id);
	}
	
	//user login
	@Override
	public User login(UserCredential user) {
		User users = findByEmail(user.getEmail());
		
		return users;	
	}
	
	@Override
	public List<User> getAllApprenantWithoutAccess() {
		return currentSession().createQuery("from User where access = 0", User.class).list();

	}
	
	//get user email
	@Override
	public User findByEmail(String email) {
		return (User)currentSession().createQuery("from User where email = :email", User.class).setParameter("email", email).uniqueResult();
	}


}
