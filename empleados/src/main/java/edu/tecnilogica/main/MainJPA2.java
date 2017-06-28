package edu.tecnilogica.main;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class MainJPA2 {
	
	public static void main (String[] args) {
		
		EntityManagerFactory emf = null;
		try {
			
			emf = JPAFactory.getEntityManagerFactory();
			
			//TRANSFORMO A HIBERNATESESSIONFACTORY
			//PASO AL API DE HIBERNATE
			SessionFactory sf = emf.unwrap(SessionFactory.class);
			
			Session sesion = sf.openSession();
			
			Transaction txh = null;
			try { //Transaccion
				
				txh = sesion.beginTransaction();

				Employees emp = sesion.get(Employees.class, 100);
				
				System.out.println("Nombre del empleado = " + emp.getFirstName());
				System.out.println("Salario = " + emp.getSalary());
				
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
