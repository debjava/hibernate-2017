package com.ddlab.rnd.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void saveCustomer(SessionFactory sessionFactory) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Customer cust1 = new Customer();
			cust1.setFirstName("John Abraham");

			Address address1 = new Address("Kerala");
			/*
			 * In case of Bidirectional
			 * set Address to Customer
			 * and
			 * set Customer to Address
			 * Otherwise, you will get foreign key as null
			 */
			cust1.setAddress(address1);
			address1.setCustomer(cust1);

			// Save customer
			session.save(cust1);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void saveAddress(SessionFactory sessionFactory) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Address address1 = new Address("Tamil Nadu");

			Customer cust1 = new Customer();
			cust1.setFirstName("Vidya Balan");
			address1.setCustomer(cust1);
			
			//Also set address to customer
			cust1.setAddress(address1);

			// Save Address as it is bidirectional
			session.save(address1);
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

		saveCustomer(sessionFactory);
		saveAddress(sessionFactory);
		
		System.out.println("successfully saved into database");
	}
}
