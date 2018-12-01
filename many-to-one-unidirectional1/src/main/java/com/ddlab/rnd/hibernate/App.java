package com.ddlab.rnd.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();

		Student student1 = new Student("Sam");
		Student student2 = new Student("Joshua");
		Student student3 = new Student("Peter");

		University university = new University("CAMBRIDGE");

		student1.setUniversity(university);
		student2.setUniversity(university);
		student3.setUniversity(university);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(university);
			session.save(student1);
			session.save(student2);
			session.save(student3);

			tx.commit();

			List<Student> students = (List<Student>)session.createQuery("from Student ").list();
			for(Student s: students){
				System.out.println("Details : "+s);
				System.out.println("Student University Details: "+s.getUniversity());
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}
}
