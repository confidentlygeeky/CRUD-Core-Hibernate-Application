package com.niit.CRUDhibernateTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.CRUDhibernatedao.UserDao;
import com.niit.CRUDhibernatedaoimpl.UserDAOImpl;
import com.niit.CRUDhibernatemodel.User;

public class UserTest {
	
	UserDao userDao;

	@Before
	public void setUp() throws Exception {
		userDao = new UserDAOImpl();
		
	}

	@After
	public void tearDown() throws Exception {
		userDao=null;
	}
	
	@Ignore
	@Test
	public void userListTest() {
		
		List<User> getUserList = userDao.getuserList();
		for(User user:getUserList) {
			System.out.println("Name: "+user.getUsername());
			System.out.println("password: "+user.getPassword());
			System.out.println("Contact: "+user.getPhone_number());
		}
		assertEquals(getUserList.size() >0, userDao.getuserList());
	}
	
	@Ignore
	@Test
	public void addUser() {
		User user = new User();
		user.setUsername("Yash");
		user.setPassword("pass12345");
		user.setPhone_number("934123343");
		
		assertEquals(true, userDao.addUser(user));
	}
	
	@Ignore
	@Test
	public void updateUser() {
		User user = userDao.getUserById(2);
		user.setUsername("Jayesh");
		user.setPassword("pass@123");
		user.setPhone_number("98204567");
		assertEquals(true, userDao.updateUser(user));
	}
	

	@Test
	public void deleteUser() {
		User user = userDao.getUserById(66);
		assertEquals(true, userDao.deleteUser(user));
	}
	
	
}
