package com.ddlab.rnd.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Customer cust1 = new Customer();
			cust1.setFirstName("Deb");

			Address address1 = new Address("Odisha");
			cust1.setAddress(address1);
			
			//First save address
			session.save(address1);
			
			//Second save customer
			session.save(cust1);

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
