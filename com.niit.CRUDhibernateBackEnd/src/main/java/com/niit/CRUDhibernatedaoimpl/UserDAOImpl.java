package com.niit.CRUDhibernatedaoimpl;

import java.util.List;

import org.hibernate.Session;

import com.niit.CRUDhibernateconfig.DbConfig;
import com.niit.CRUDhibernatedao.UserDao;
import com.niit.CRUDhibernatemodel.User;



public class UserDAOImpl implements UserDao {
	Session session = DbConfig.getSession();
	
	
	public boolean addUser(User user) {
		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();
		return true;
	}

	public User getUserById(int userId) {
		User user = (User) session.createQuery("from User where userId = " + userId).list().get(0);
		return user;
	}

	public List<User> getuserList() {
		session.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<User> getUserList = session.createQuery("from User").list();
		 session.getTransaction().commit();
		return getUserList;
	
	}


	public boolean updateUser(User user) {
		session.getTransaction().begin();
		session.update(user);
		session.getTransaction().commit();
		return true;
	}

	public boolean  deleteUser(User user){
		session.getTransaction().begin();
		session.delete(user);
		session.getTransaction().commit();
		return true;
		
	}
	

}
