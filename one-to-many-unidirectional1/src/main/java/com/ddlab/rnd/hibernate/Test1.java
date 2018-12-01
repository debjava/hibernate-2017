package com.ddlab.rnd.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Student student1 = new Student("Sam");
			Student student2 = new Student("Joshua");

			Subject subject1 = new Subject("Economics");
			Subject subject2 = new Subject("Politics");
			Subject subject3 = new Subject("Foreign Affairs");

			// Student1 have 3 subjects
			student1.getSubjects().add(subject1);
			student1.getSubjects().add(subject2);
			student1.getSubjects().add(subject3);

			// Student2 have 2 subjects
			student2.getSubjects().add(subject1);
			student2.getSubjects().add(subject2);


			session.save(student1);
			session.save(student2);

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
		System.out.println("successfully saved into database");
	}

}
