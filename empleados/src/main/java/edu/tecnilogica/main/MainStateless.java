package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Regions;
import edu.tecnilogica.entity.Registro;

public class MainStateless {
	
	public static void main (String[] args) {
		
		SessionFactory sf = null;
		try {
			
			sf = HibernateFactory.getSessionFactory();
			StatelessSession ss = sf.openStatelessSession();
			Transaction tx = null;
			try { //Transaccion
				
				tx = ss.beginTransaction();
				
				for (int i = 0; i < 100; i++) {
					ss.insert(new Registro());
				}
				
				tx.commit();
				
			} catch (Exception e) {
				tx.rollback();
			} finally {
				ss.close();
			}
			
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			sf.close();
		}
		
		
	}

}
