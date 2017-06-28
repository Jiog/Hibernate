package edu.tecnilogica.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.tecnilogica.entity.Regions;

public class SelectCriteria2 {
	
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
				
				
				CriteriaQuery<Regions> cq = cb.createQuery(Regions.class);
				
				Root<Regions> root = cq.from(Regions.class);

				cq.where(cb.equal(root.get("regionName"), "Europe"));

				TypedQuery<Regions> tq = em.createQuery(cq);
				
				List<Regions> lnr = tq.getResultList();
				
				for (Regions region : lnr) {
					System.out.println("Región id = " + region.getRegionId());
					System.out.println("Región name = " + region.getRegionName());
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
