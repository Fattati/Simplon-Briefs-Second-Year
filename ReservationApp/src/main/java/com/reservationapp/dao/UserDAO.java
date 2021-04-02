package com.reservationapp.dao;

import java.util.List;

import com.reservationapp.model.User;
import com.reservationapp.model.UserCredential;



public interface UserDAO {
	public void save(User User);
	public void update(User User);
	public User get(Long id);
	public User login(UserCredential user);
	public List<User> getAllApprenantWithoutAccess();
	public User findByEmail(String email);
	

}
