package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class MainHibernate100206 {
	
	public static void main (String[] args) {
		
		SessionFactory sf = null;
		Session sesion = null;
		try {
			
			sf = HibernateFactory.getSessionFactory();
			sesion = sf.openSession();
			Transaction tx = null;
			try { //Transaccion
				
				tx = sesion.beginTransaction();
				
				for (int i = 100; i<207; i++) {
					Employees emp = sesion.get(Employees.class, i);
					
					System.out.println("ID = " + emp.getEmployeeId());
					System.out.println("Nombre = " + emp.getFirstName());
					System.out.println("Salario = " + emp.getSalary());
					System.out.println("Actualizando 7% salario");
					emp.setSalary(emp.getSalary().multiply(new BigDecimal(1.07)));
					System.out.println("Nuevo Salario = " + emp.getSalary());

				}
				
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
