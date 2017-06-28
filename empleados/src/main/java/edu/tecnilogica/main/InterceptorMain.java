package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.RegistroTabla;

public class InterceptorMain {
	
	public static void main (String[] args) {
		
		SessionFactory sf = null;
		try {
			
			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.withOptions().interceptor(new MyInterceptor()).openSession();
			Transaction tx = null;
			try { //Transaccion
				
				tx = sesion.beginTransaction();
				
				RegistroTabla r1 = new RegistroTabla();
				
				tx = sesion.beginTransaction();
				
				sesion.save(r1);
				
				System.out.println("Registro leído = " + r1.getId());
				
				tx.commit();
				
			} catch (Exception e) {
				tx.rollback();
			} finally {
				sesion.close();
			}
			
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			sf.close();
		}
		
		
	}

}
