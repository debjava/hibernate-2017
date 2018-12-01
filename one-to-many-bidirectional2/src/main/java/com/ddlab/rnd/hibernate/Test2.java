package com.ddlab.rnd.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

	public static void saveStudent(SessionFactory sessionFactory, Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			session.save(student);

			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

	public static void saveSubject(SessionFactory sessionFactory, Subject subject) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			session.save(subject);

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

		Student student1 = new Student("Sam");

		Subject subject1 = new Subject("Economics");
		subject1.setStudent(student1);
		Subject subject2 = new Subject("Politics");
		subject2.setStudent(student1);
		Subject subject3 = new Subject("Foreign Affairs");
		subject3.setStudent(student1);

		// Student1 have 3 subjects
		student1.getSubjects().add(subject1);
		student1.getSubjects().add(subject2);
		student1.getSubjects().add(subject3);

		// Save Student along with Subject
		saveStudent(sessionFactory, student1);

		Student student2 = new Student("Deb");
		subject1.setStudent(student2);
		student2.getSubjects().add(subject2);
		// Save subject along with Student
		saveSubject(sessionFactory, subject1);
		System.out.println("successfully saved into database");
	}

}
