package com.tut.projectWithMaven;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = null;
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
            // You may add entity classes or mappings here using configuration.addAnnotatedClass() or configuration.addResource()

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory();            		
//            		buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }        
    	
//    	save()
    	Student s = new Student(101,"JOHN","DELHI");
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	
    	session.save(s);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	
    	
        
    }
}
