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

public class SelectCriteria4 {
	
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
				
				
				CriteriaQuery<MiniEmpleado> cq = cb.createQuery(MiniEmpleado.class);
				
				Root<Employees> root = cq.from(Employees.class);

				Path<Integer> pathId = root.get("employeeId");
				Path<String> pathFn = root.get("firstName");
				
				cq.select(cb.construct(MiniEmpleado.class, pathId, pathFn));

				TypedQuery<MiniEmpleado> tq = em.createQuery(cq);
				
				List<MiniEmpleado> lme = tq.getResultList();
				
				for (MiniEmpleado empleado : lme) {
					System.out.println(empleado);
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
