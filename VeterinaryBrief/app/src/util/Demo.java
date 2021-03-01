package util;

import org.hibernate.Session;

import beans.*;

public class Demo {

	public static void main(String[] args) {
		
		Session session =HibernateUtil.openSession(); 
		
		try {
			//User user =  new  User("Reda","reda@gmail.com","whentheycry", "admin");
			session.beginTransaction();
			//session.save(user);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
