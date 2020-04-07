package client;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.Message;


public class HelloWorldClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		session.beginTransaction();
       
        		//inserting the data to the table
        		Message message = new Message( "Hello World with Hibernate & JPA Annotations" );
        		session.save(message); 
        		
        		//updating the data in the table
        		Message msg = session.get(Message.class, 3L);
        		msg.setText("Bello");        		
 
        		//Deleting the data from the table
        		Message msg1 = session.get(Message.class, 5L);
        		session.delete(msg1);
        		
        		session.getTransaction().commit();
        		session.close();
	
	}
}

