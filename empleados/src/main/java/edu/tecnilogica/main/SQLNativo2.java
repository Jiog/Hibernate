package edu.tecnilogica.main;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class SQLNativo2 {
	
	public static void main (String[] args) {
		
		try {
			
			Session sesion = HibernateFactory.getSessionFactory().openSession();
			Transaction tx = null;
			try { //Transaccion
				
				tx = sesion.beginTransaction();
				
				SQLQuery sql = sesion.createSQLQuery("select * from employees");

				sql.addEntity(Employees.class);
				List<Employees> lo = sql.list();
				
				for (Employees o : lo) {
					System.out.println(o);
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
			HibernateFactory.getSessionFactory().close();
		}
		
		
	}

}
