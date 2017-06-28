package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Regions;

public class MainHibernate2 {
	
	public static void main (String[] args) {
		
		SessionFactory sf = null;
		try {
			
			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();
			Transaction tx = null;
			try { //Transaccion
				
				Regions rg = new Regions();//rg es TRANSIENT
				rg.setRegionId(new BigDecimal(33));
				rg.setRegionName("Ciquitistan");
				
				tx = sesion.beginTransaction();
				
				sesion.save(rg); //PERSISTENT
				
				rg.setRegionName("Azkoitia");
				
				//rg = sesion.get(Regions.class, new BigDecimal(1));
				
				System.out.println("Región leída = " + rg.getRegionName());
				System.out.println("Región leída = " + rg.getRegionId());
				
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
