package service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import beans.User;
import util.HibernateUtil;

public class UserS {
	
	public User getByEmail(String email) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("from User where email = :email ");
            query.setParameter("email", email);
            query.setMaxResults(1);
            //
            if (query.list().size() == 0)
                return null;
            User user = (User) query.list().get(0);
            transaction.commit();
            //
            return user;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

}
