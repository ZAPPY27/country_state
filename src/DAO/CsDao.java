package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CountryVo;
import VO.StateVo;


public class CsDao {

	public void add(CountryVo vo) {
		// TODO Auto-generated method stub
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(vo);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
public List search(CountryVo v){
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("From CountryVo");
		List ls = q.list();
		transaction.commit();
		session.close();
		return ls;
		}
public void adds(StateVo vos) {
	// TODO Auto-generated method stub
	try
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.save(vos);
		
		transaction.commit();
		
		session.close();
	}
catch(Exception ex)
	{
		ex.printStackTrace();
	}
}
public List search(StateVo vo) {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	
	Query q = session.createQuery("From StateVo");
	List ls = q.list();
	transaction.commit();
	session.close();
	return ls;
}
public void update(StateVo vos) {
	// TODO Auto-generated method stub
	try
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		session.update(vos);
		
		transaction.commit();
		
		session.close();
	}
catch(Exception ex)
	{
		ex.printStackTrace();
	}
}


}
