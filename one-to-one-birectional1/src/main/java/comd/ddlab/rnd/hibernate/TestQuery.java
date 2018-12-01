package comd.ddlab.rnd.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuery {

	public static void showCustomer(Session session) {
		try {
			// String hql = "FROM Customer";
			String hql = "FROM Customer C where C.firstName =:firstName";
			Query query = session.createQuery(hql);
			query.setParameter("firstName", "Deb");
			List results = query.list();
			for (int i = 0; i < results.size(); i++) {
				Customer cust = (Customer) results.get(i);
				System.out.println(cust.getCustomerId()+"---"+cust.getFirstName()+"---"+cust.getAddress().getAddressId()+"---"+cust.getAddress().getCity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showAddress(Session session) {
		try {
//			String hql = "FROM Address";
			 String hql = "FROM Address C where C.addressId =:addressId";
			Query query = session.createQuery(hql);
			query.setParameter("addressId", 1);
			List results = query.list();
			for (int i = 0; i < results.size(); i++) {
				Address adrs = (Address) results.get(i);
				System.out.println(adrs.getAddressId()+"--"+adrs.getCity()+"---"+adrs.getCustomer().getFirstName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();

		showCustomer(session);

		showAddress(session);

	}

}
