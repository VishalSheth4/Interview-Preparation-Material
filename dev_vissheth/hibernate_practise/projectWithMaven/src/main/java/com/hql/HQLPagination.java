package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.tut.mapping.ProjectMappingConfig;
import com.tut.projectWithMaven.Student;

public class HQLPagination {
	public static void main(String[] args) {
		ProjectMappingConfig config = new ProjectMappingConfig();
		
		Session session = config.getConfiguration();
		
		String queryS="from Student";
		
		Query query = session.createQuery(queryS);
		
//		Implementing Pagination
		
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List<Student> list = query.list();
		
		for(Student stu : list) {
			System.out.println(stu.getName());
		}
		
		session.close();
	}
}
