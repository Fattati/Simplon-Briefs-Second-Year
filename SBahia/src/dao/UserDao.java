package dao;

import java.util.List;

import beans.User;


public interface UserDao {
	public String saveUser(User user);
	public List<User> search (String n);
	public User update(User p);
	public void delete(int userId);
	public User getUser(int userId);

}
