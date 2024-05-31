package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.tut.mapping.ProjectMappingConfig;
import com.tut.projectWithMaven.Student;

public class sqlQuery {
	public static void main(String[] args) {
		ProjectMappingConfig config = new ProjectMappingConfig();
		
		Session session = config.getConfiguration();
		
		String q = "select * from student";
		
		NativeQuery nq = session.createSQLQuery(q);
		
		List<Object[]> list = nq.list();
		
		for(Object[] stu : list) {
			System.out.println(Arrays.stream(stu));
		}
		
	}
}
