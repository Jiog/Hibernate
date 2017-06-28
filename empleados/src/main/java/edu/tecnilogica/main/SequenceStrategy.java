package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.RegistroSec;

public class SequenceStrategy {
	
	public static void main (String[] args) {
		
		SessionFactory sf = null;
		try {
			
			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();
			Transaction tx = null;
			try { //Transaccion
				
				RegistroSec r1 = new RegistroSec();
				RegistroSec r2 = new RegistroSec();
				RegistroSec r3 = new RegistroSec();

				
				tx = sesion.beginTransaction();
				
				sesion.save(r1); //PERSISTENT
				sesion.save(r2);
				sesion.save(r3);
				
				System.out.println("Registro leído = " + r1.getId());
				System.out.println("Registro leído = " + r2.getId());
				System.out.println("Registro leído = " + r3.getId());
				
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
