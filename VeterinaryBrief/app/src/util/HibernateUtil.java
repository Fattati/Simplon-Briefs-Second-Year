package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.User;

public class HibernateUtil {
	private static SessionFactory factory;
	
	private HibernateUtil() {
		
	}
	public static SessionFactory getSessionFactory() {
		if (factory == null) {
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			factory = setupClasses(config).buildSessionFactory();
		}
		return factory;
	}
	
	private static Configuration setupClasses(Configuration config) {
        config.addAnnotatedClass(User.class);
        
        return config;
    }
	
	public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void closeSession() {
        getSessionFactory().close();
    }
    
}
