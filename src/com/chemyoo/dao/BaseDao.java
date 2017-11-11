package com.chemyoo.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class BaseDao{
	private static Configuration config;
	private static SessionFactory factory;
	
	
	static
	{
		config= new Configuration();
		config.configure();
		factory=config.buildSessionFactory();
	}
	
	protected static Session openSession()
	{
		return factory.openSession();
	}
	public static void main(String a[])
	{
		openSession();
	}

}
