
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
        	
        			Guide guide1 = new Guide("2000MO10790", "Mikzvze Lawson", 1000);
        			Guide guide2 = new Guide("2000IM10902", "Iazvzn Lamb", 2000);
        	
        			Student student1 = new Student("2014JT50124", "Joh54n Smith", guide1);
        			Student student2 = new Student("2014AL50457", "Azzvzmy Gill", guide1);
        	
        			guide1.getStudents().add(student1);
        			guide1.getStudents().add(student2);
        	
        			session.persist(guide1);
        			session.persist(guide2);
        	
        			//Updating inverse end
        			
		        	/*Guide guide = (Guide) session.get(Guide.class, 2L);        	
		        	Student student = (Student) session.get(Student.class, 2L);          	
		        	guide.getStudents().add(student);*/
	 				

        			//Updating owner
        			
		        	/*Guide guide = (Guide) session.get(Guide.class, 1L);        	
		        	Student student = (Student) session.get(Student.class, 6L);          	
		        	student.setGuide(guide);
		 			*/        	
        	
        			//Updating inverse end (after adding addStudent(Student) in Guide entity)
					/*
		        	Guide guide = (Guide) session.get(Guide.class, 2L);        	
		        	Student student = (Student) session.get(Student.class, 1L);          	
		        	guide.addStudent(student);
		        	*/
  
        			txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}










