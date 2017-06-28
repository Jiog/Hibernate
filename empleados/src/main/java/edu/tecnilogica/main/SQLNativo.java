package edu.tecnilogica.main;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SQLNativo {
	
	public static void main (String[] args) {
		
		try {
			
			Session sesion = HibernateFactory.getSessionFactory().openSession();
			Transaction tx = null;
			try { //Transaccion
				
				tx = sesion.beginTransaction();
				
				SQLQuery sql = sesion.createSQLQuery("select employee_id, email from employees");

				List<Object[]> lo = sql.list();
				
				for (Object[] o : lo) {
					System.out.println(o[0] + "-" + o[1]);
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
