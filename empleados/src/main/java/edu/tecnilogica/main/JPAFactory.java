package edu.tecnilogica.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {
	
	private static EntityManagerFactory factory;
	
	static {
		new JPAFactory();
	}
	
	private JPAFactory () {
		
		try {
			factory = new Persistence().createEntityManagerFactory("unit");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static EntityManagerFactory getEntityManagerFactory () {
		return factory;
	}
}
