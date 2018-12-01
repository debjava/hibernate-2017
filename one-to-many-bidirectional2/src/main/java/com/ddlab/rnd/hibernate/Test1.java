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

			// Student2 have 2 subjects
			Student student2 = new Student("Joshua");
			student2.getSubjects().add(subject1);
			student2.getSubjects().add(subject2);

			// session.save(student1);

			// session.save(student2);

			// session.saveOrUpdate(student2);

			// Lets try to save subject which will save student
			// To save , use
			/*
			 * @ManyToOne(cascade=CascadeType.ALL)
			 * 
			 * @JoinColumn(name="student_id") private Student student;
			 */
			// Subject subject4 = new Subject("Law and Administration");
			// Student student4 = new Student("Deb");
			// subject4.setStudent(student4);
			// session.save(subject4);

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
