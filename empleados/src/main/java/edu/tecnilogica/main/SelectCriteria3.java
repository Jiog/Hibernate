package edu.tecnilogica.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import edu.tecnilogica.entity.Employees;

public class SelectCriteria3 {
	
	public static void main (String[] args) {
		
		EntityManagerFactory emf = null;
		try {
			
			emf = JPAFactory.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = null;
			try { //Transaccion
				
				tx = em.getTransaction();
				tx.begin();
				
				CriteriaBuilder cb = em.getCriteriaBuilder();
				
				
				CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
				
				Root<Employees> root = cq.from(Employees.class);

				Path<Integer> pathId = root.get("employeeId");
				Path<String> pathFn = root.get("firstName");
				
				cq.select(cb.array(pathId, pathFn));

				TypedQuery<Object[]> tq = em.createQuery(cq);
				
				List<Object[]> lo = tq.getResultList();
				
				for (Object[] o : lo) {
					System.out.println((Integer) o[0]);
					System.out.println((String) o[1]);
				}
				
				tx.commit();
				
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				em.close();
			}
			
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			emf.close();
		}
		
		
	}

}
