package com.tut.projectWithMaven;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ProjectConfig {
	public ProjectConfig(Object obj) {
		// TODO Auto-generated constructor stub
	}

	public ProjectConfig() {
		// TODO Auto-generated constructor stub
	}

	public Session getConfiguration() {
		SessionFactory sessionFactory=null;
		try {
	        Configuration configuration = new Configuration();
	
	        // Set Hibernate properties programmatically
	        Properties properties = new Properties();
	        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/myhiber");
	        properties.setProperty("hibernate.connection.username", "root");
	        properties.setProperty("hibernate.connection.password", "admin");
	        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        properties.setProperty("hibernate.hbm2ddl.auto", "update");
	        properties.setProperty("hibernate.show_sql", "true");
	        configuration.setProperties(properties);
	
	        configuration.addAnnotatedClass(Student.class);
	        configuration.addAnnotatedClass(Address.class);
	        // You may add entity classes or mappings here using configuration.addAnnotatedClass() or configuration.addResource()
	
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties()).build();
	
	        sessionFactory = configuration.buildSessionFactory();            		
	//        		buildSessionFactory(serviceRegistry);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		return session;
		
	}
	public void saveObject(Object obj) {
		Session session = getConfiguration();
		session.save(obj);
    	session.getTransaction().commit();
    	session.close();       
	}
	
	public Object getStudentObject() {
		Session session = getConfiguration();
		Student stu = session.get(Student.class, 101);
		System.out.println(stu);
		return null;
	}
	
	public Object getAddressObject() {
		Session session = getConfiguration();
		Address stu = session.get(Address.class, 2);
		System.out.println(stu);
		return null;
	}
	
	public Object loadStudentObject() {
		Session session = getConfiguration();
		Student stu = session.load(Student.class, 101);
		// load will hit db only when any operation will be done on fetch object.
		System.out.println(stu);
		return null;
	}
}
