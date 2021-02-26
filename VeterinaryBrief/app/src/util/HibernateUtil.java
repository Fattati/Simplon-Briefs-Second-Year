package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Message;
import beans.Rendezvous;
import beans.User;

public class HibernateUtil {
	private static SessionFactory factory;
	
	private HibernateUtil() {
		
	}
	public static SessionFactory getSessionFactory() {
		if (factory == null) {
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			factory = Classes(config).buildSessionFactory();
		}
		return factory;
	}
	
	private static Configuration Classes(Configuration config) {
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Message.class);
        config.addAnnotatedClass(Rendezvous.class);
        
        return config;
    }
	
	public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void closeSession() {
        getSessionFactory().close();
    }
    
}
