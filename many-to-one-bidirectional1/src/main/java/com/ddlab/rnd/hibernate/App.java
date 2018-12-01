package com.ddlab.rnd.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void saveUniversity(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();

		Student student1 = new Student("Sam");
		Student student2 = new Student("Joshua");
		Student student3 = new Student("Peter");

		University university = new University("CAMBRIDGE");
		List<Student> allStudents = new ArrayList<Student>();

		student1.setUniversity(university);
		student2.setUniversity(university);
		student3.setUniversity(university);

		allStudents.add(student1);
		allStudents.add(student2);
		allStudents.add(student3);

		university.setStudents(allStudents);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(university);

			tx.commit();

			List<Student> students = (List<Student>) session.createQuery("from Student ").list();
			for (Student s : students) {
				System.out.println("Student Details : " + s);
				System.out.println("Student University Details: " + s.getUniversity());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void saveStudent(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();

		University university = new University("Standford");
		Student student1 = new Student("Deb");
		student1.setUniversity(university);
		List<Student> allStudents = new ArrayList<Student>();
		allStudents.add(student1);
		university.setStudents(allStudents);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(student1);

			tx.commit();

			List<University> universities = (List<University>) session.createQuery("from University ").list();
			for (University u : universities) {
				System.out.println(u.getName()+"---"+u.getStudents());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("hibSessionFactory");

		saveUniversity(sessionFactory);

		saveStudent(sessionFactory);
		
		System.out.println("All information saved successfully ...");
	}
}
