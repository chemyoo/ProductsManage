package com.chemyoo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static Configuration config;
	private static SessionFactory factory;
	
	static
	{
		config= new Configuration();
		config.configure();
		factory=config.buildSessionFactory();
	}
	
	public static Session openSession()
	{
		return factory.openSession();
	}

}
