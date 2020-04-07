
package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Guide;
import entity.Student;


public class HelloWorldClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			Guide guide1 = new Guide("1000MO105141", "thor", 1200);
        			Student student1 = new Student("2014JT50014", "hulk", guide1);
        			Student student2 = new Student("2014JT50028", "iron man", guide1);

        			session.save(student1);
        			session.save(student2);
        			
        			session.remove(student1);
        			session.remove(student2);
        			
        			
	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}











