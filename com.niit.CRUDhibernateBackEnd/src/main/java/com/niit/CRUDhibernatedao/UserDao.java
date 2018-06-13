package com.niit.CRUDhibernatedao;

import java.util.List;

import com.niit.CRUDhibernatemodel.User;

public interface UserDao {
	
	public boolean addUser(User user);
	public User getUserById(int userId);
	public List<User> getuserList();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
}
