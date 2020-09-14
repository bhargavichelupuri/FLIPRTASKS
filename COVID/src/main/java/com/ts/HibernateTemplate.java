package com.ts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.rest.dto.Patients;

public class HibernateTemplate {
	

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj){
		System.out.println("Inside Template...");
		int result=0;
		Transaction tx=null;		
		try {
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			session.save(obj);
			tx.commit();
			result=1;		
		} catch (Exception e) {
			System.out.println("failure...");		
			tx.rollback();			
			e.printStackTrace();
		}		
		return result;
	}
	
	
		
	
	
	
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		Session session=sessionFactory.openSession();
		
		try {
			
			
			tx=session.beginTransaction();
			//sessionFactory.getCurrentSession().merge(obj);
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			session.close();
			
		} catch (Exception e) {
		    
			tx.rollback();
			System.out.println("update failure...");
			e.printStackTrace();
			
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			System.out.println(obj);
			System.out.println(serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
			
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
			
			System.out.println("delete failure...");
		}
		
		return result;
	}

	
	public static List<Patients> viewAllPatients() {
		String queryString1 = "from Patients";
		Query query1 = sessionFactory.openSession().createQuery(queryString1);
		List<Patients> patients = new ArrayList<Patients>();
		patients = query1.list();
		return patients;
	}







	public static Object getStaticstics(String ageGroup, String gender) {
		 SessionFactory s = new Configuration().configure().buildSessionFactory();
			Session session = s.openSession();
			session.beginTransaction();
			Query query = session.createQuery("select count(*) from Patients where ageEstimate = :ageGroup and gender = :gender");
			query.setString("ageGroup", ageGroup);
			query.setString("gender", gender);
			//List books = query.list();
			Object queryResult = query.uniqueResult();
			//Long queryResult =  (Long) query.uniqueResult();
			System.out.println(queryResult);
			
			session.getTransaction().commit();
			session.close();
			return queryResult;// TODO Auto-generated method stub
		
	}
	
	
	


}	
			
			
			
			
			
			
			
			
			
			
	 // end



		


















/*public static Object getObjectByUserPass(String loginId,String password) {

String queryString = "from Employee where email = :loginId and password =:password";
  Query query = sessionFactory.openSession().createQuery(queryString);
  query.setString("loginId", loginId);
  query.setString("password", password);
  Object queryResult = query.uniqueResult();
  Employee employee = (Employee)queryResult;
  return employee; 
}

	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;	
		try {			
			return sessionFactory.openSession().get(c,serializable);			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return obj;
	}  
	
	   
	public static Object getObjectByEmail(String email) {
		
		String queryString = "from customer where email = :email";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("email", email);
		  Object queryResult = query.uniqueResult();
		  Customer customer = (Customer)queryResult;
		  return customer; 
	}
	public static Object getObjectByLoginId(String loginId) {
		
		  String queryString = "from customer where loginId = :loginId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("loginId", loginId);
		  Object queryResult = query.uniqueResult();
		  Customer customer = (Customer)queryResult;
		  return customer; 
	}
	
	
	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
		*/

