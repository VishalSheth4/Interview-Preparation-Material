package com.tut.mapping;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ProjectMappingConfig {
	public ProjectMappingConfig(Object obj) {
		// TODO Auto-generated constructor stub
	}

	public ProjectMappingConfig() {
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
	
	        configuration.addAnnotatedClass(Question.class);
	        configuration.addAnnotatedClass(Answer.class);
	        // You may add entity classes or mappings here using configuration.addAnnotatedClass() or configuration.addResource()
	
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties()).build();
	
	        sessionFactory = configuration.buildSessionFactory();            		
	//        		buildSessionFactory(serviceRegistry);
	        
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			System.out.println("------ got Session ----------");
			return session;
	    } catch (Exception e) {
	        e.printStackTrace();
			System.out.println("------ Failed get Null Session ----------");

	        return null;
	    }
	}
	public void saveObject(Object obj) {
		Session session = getConfiguration();
		session.save(obj);
    	session.getTransaction().commit();
    	session.close();       
	}
	
	public Object getQuestionObject() {
		Session session = getConfiguration();
		Question stu = session.get(Question.class, 101);
		System.out.println(stu);
		return null;
	}
	
	public Object getAddressObject() {
		Session session = getConfiguration();
		Answer stu = session.get(Answer.class, 2);
		System.out.println(stu);
		return null;
	}
}
