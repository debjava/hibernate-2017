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
		
		Employee e1 = new Employee();  
	    e1.setName("Deb");
	    e1.setId(1);
	    
	    PermanentEmployee pe = new PermanentEmployee();
	    pe.setName("John Abraham");
	    pe.setProjectName("Apollo");
	    pe.setId(2);
	    
	    ContractEmployee ce = new ContractEmployee();
	    ce.setName("Vidya Balan");
	    ce.setSalary(1000.50F);
	    ce.setId(3);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(e1);
			session.save(pe);
			session.save(ce);
	        
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
