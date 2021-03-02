package dao;

import org.hibernate.Session;

import beans.Rendezvous;
import util.HibernateUtil;

public class RendezvousDao {
	
	public void saveRendezvous(Rendezvous rendezvous) {
        Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(rendezvous);
        session.getTransaction().commit();
        session.close();
    }

}
