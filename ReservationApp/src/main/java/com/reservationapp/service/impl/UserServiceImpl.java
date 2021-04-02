package com.reservationapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservationapp.dao.UserDAO;
import com.reservationapp.model.User;
import com.reservationapp.model.UserCredential;
import com.reservationapp.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;
	
	@Transactional
	@Override
	public void save(User User) {
		userDAO.save(User);
		
	}
	
	@Transactional
	@Override
	public User login(UserCredential users) {
		return userDAO.login(users);
	}
	
	@Transactional
	@Override
	public List<User> getAllApprenantWithoutAccess() {
		return userDAO.getAllApprenantWithoutAccess();
	}
	
	@Transactional
	@Override
	public User findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	@Override
	public User get(Long id) {
		return userDAO.get(id);
	}

	@Override
	public void update(User User) {
		userDAO.update(User);
		
	}


}
