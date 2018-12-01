package com.ddlab.rnd.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void saveStudent(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Student student1 = new Student("John Abraham");
			Subject subject1 = new Subject("Chemistry");
			subject1.setStudent(student1);
			student1.setSubject(subject1);
			
			//Save Student
			session.save(student1);

			transaction.commit();
			
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
	
	public static void saveSubject(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Student student1 = new Student("Vidya Balan");
			Subject subject1 = new Subject("Biology");
			subject1.setStudent(student1);
			student1.setSubject(subject1);
			
			//Save Subject
			session.save(subject1);

			transaction.commit();
			
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("hibSessionFactory");
		
		saveStudent(sessionFactory);
		saveSubject(sessionFactory);

		System.out.println("successfully saved into database");
	}
}
