package comd.ddlab.rnd.hibernate;

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
			cust1.setFirstName("Sambit");

			Address address1 = new Address("Bhubaneswar");
			cust1.setAddress(address1);
			session.save(cust1);//save customer along with address
			
			//Save another one
			Customer cust2 = new Customer();
			cust2.setFirstName("Vidya");

			Address address2 = new Address("Chennai");
			cust2.setAddress(address2);
			address2.setCustomer(cust2);
			session.save(address2);//save address along with customer

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
