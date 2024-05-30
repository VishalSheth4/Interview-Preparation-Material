package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tut.mapping.ProjectMappingConfig;
import com.tut.projectWithMaven.Student;

public class HQLExample {
	public static void main(String[] args) {
		ProjectMappingConfig config = new ProjectMappingConfig();
		Session session = config.getConfiguration();

		
//		--------- PART 1 ---------
		// HQL ---
		String query = "from Student";
		
		Query q = session.createQuery(query);
		
		/*Note
		 *  Single - (Unique) q.uniqueResult();
		 *  Multiple - list
		*/
		
		List<Student> list = q.list();
		for(Student stu : list)
			System.out.println(stu.getName());
		
		
//		--------- PART 2 ---------
		String var = "Lucknow";
		String query1 = "from Student where city :x";
		Query q2 = session.createQuery(query1);
		
		q2.setParameter("x",var);
		List<Student> list1 = q.list();
		for(Student stu : list1)
			System.out.println(stu.getName());
		
		
//		--------- PART 3 DELETE ---------
		// HQL ---
		session.beginTransaction();
		String var1 = "Lucknow";
		String query11 = "delete from Student where city=:c";
		
		Query q1 = session.createQuery(query11);
		q1.setParameter("c",var1);
		
		int result = q1.executeUpdate();
		
		
//		--------- PART 4 UPDATE ---------
		// HQL ---
		Transaction tx = session.beginTransaction();
		String city = "Lucknow";
		String updateQuery = "update Student set city=:c";
		
		Query uquery = session.createQuery(updateQuery);
		uquery.setParameter("c",var1);
		
		int updateResult = q1.executeUpdate();
		
		tx.commit();
		
		
//		--------- PART 5 JOIN ---------
		// HQL ---
		Transaction tx1 = session.beginTransaction();
		String city1 = "Lucknow";
		String updateQuery1 = "select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answer as a";
		
		Query joinQuery = session.createQuery(updateQuery1);
		
		
		List<Student> list11 = joinQuery.getResultList();
		for(Student stu : list11)
			System.out.println(stu.getName());
		tx1.commit();
		

	}
}
