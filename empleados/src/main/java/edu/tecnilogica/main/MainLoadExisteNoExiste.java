package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Regions;

public class MainLoadExisteNoExiste {
	
	public static void main (String[] args) {
		
		SessionFactory sf = null;
		try {
			
			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();
			Transaction tx = null;
			try { //Transaccion
				
				tx = sesion.beginTransaction();
				
				for(int i = 1; i<=5; i++) {
					Regions rg = sesion.load(Regions.class, new BigDecimal(i));
					
					if (rg != null) {
						System.out.println("Regi�n no es Null");
						System.out.println("Regi�n le�da = " + rg.getRegionName());
						System.out.println("Regi�n le�da = " + rg.getRegionId());
					} else {
						System.out.println("Regi�n es Null");
					}
				}
				
				tx.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
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
