package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Registro;

public class UUIDStrategy {
	
	public static void main (String[] args) {
		
		SessionFactory sf = null;
		try {
			
			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();
			Transaction tx = null;
			try { //Transaccion
				
				Registro r1 = new Registro();
				Registro r2 = new Registro();
				Registro r3 = new Registro();

				
				tx = sesion.beginTransaction();
				
				sesion.save(r1); //PERSISTENT
				sesion.save(r2);
				sesion.save(r3);
				
				System.out.println("Registro le�do = " + r1.getId());
				System.out.println("Registro le�do = " + r2.getId());
				System.out.println("Registro le�do = " + r3.getId());
				
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
