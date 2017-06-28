package edu.tecnilogica.main;

import java.math.BigDecimal;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;

import edu.tecnilogica.entity.Regions;

public class MainLoadListener {
	
	public static void main (String[] args) {
		
		EntityManagerFactory emf = null;
		try {
			
			emf = JPAFactory.getEntityManagerFactory();
			
			//Como activar listener eventos para HB 5, paso al api de hibernate
			SessionFactoryImpl sfi = emf.unwrap(SessionFactoryImpl.class);
			
			EventListenerRegistry registry = sfi.getServiceRegistry().getService(EventListenerRegistry.class);
			registry.getEventListenerGroup(EventType.LOAD).appendListener(new MyLoadListener());;
			
			Session sesion = sfi.openSession();
			
			Transaction txh = null;
			try { //Transaccion
				
				txh = sesion.beginTransaction();

				Regions reg = sesion.get(Regions.class, new BigDecimal(1));
				
				System.out.println(reg);
				
				txh.commit();
				
			} catch (Exception e) {
				txh.rollback();
				e.printStackTrace();
			} finally {
				sesion.close();
			}
			
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			emf.close();
		}
		
		
	}

}
