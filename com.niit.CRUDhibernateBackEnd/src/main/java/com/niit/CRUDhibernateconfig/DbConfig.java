package com.niit.CRUDhibernateconfig;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.niit.CRUDhibernatemodel.User;

public class DbConfig {
	
	private static SessionFactory sessionFactory = null;
	
	static {
		loadSessionFactory();
	}
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		DbConfig.sessionFactory = sessionFactory;
	}

	public static void loadSessionFactory()
	{
		Configuration configuration=new Configuration();
		
		configuration.configure("hibernate.cfg.xml");
		
		configuration.addAnnotatedClass(User.class);
		
		ServiceRegistry serviceregistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();		
		setSessionFactory(configuration.buildSessionFactory(serviceregistry));
	}

	public static Session getSession() throws HibernateException {
		
		Session session = null;	
		try {
			session=getSessionFactory().openSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;	
	}
	
	

	
}
