package com.ddlab.rnd.hibernate;

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
         
        Subject subject1 = new Subject("Economics");
        Subject subject2 = new Subject("Politics");
        Subject subject3 = new Subject("Foreign Affairs");
 
        //Student1 have 3 subjects
        student1.getSubjects().add(subject1);
        student1.getSubjects().add(subject2);
        student1.getSubjects().add(subject3);
         
        //Student2 have 2 subjects
        student2.getSubjects().add(subject1);
        student2.getSubjects().add(subject2);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.persist(student1);
	        session.persist(student2);
	        
			tx.commit();
			
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
