package edu.tecnilogica.main;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class HQLFilter {
	
	public static void main (String[] args) {
		
		try {
			
			Session sesion = HibernateFactory.getSessionFactory().openSession();
			Transaction tx = null;
			try { //Transaccion
				
				tx = sesion.beginTransaction();
				
				Filter filtro = sesion.enableFilter("employeeFilter");
				filtro.setParameter("salary", 10000);
				
				Query query = sesion.createQuery("FROM Employees e");

				List<Employees> le = query.list();
				
				for (Employees emp : le) {
					System.out.println(emp);
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
