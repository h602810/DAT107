package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Ansatt;

public class AnsattDAO {
	private EntityManagerFactory emf;
	
	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("oblig3",
				Map.of("javax.persistence.jdbc.password", "Yeet1234"));
	}
	
	/*------------------------------------------------------------------*/
	
	// Søke etter ansatt på brukernavn (initialer)
	public Ansatt soekAnsattForBrukernavn(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> brna = em.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn LIKE :brukernavn", Ansatt.class);
			brna.setParameter("brukernavn", brukernavn);
			return brna.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	// Søke etter ansatt på ansatt-id 
	public Ansatt finnAnsattMedId(int ansattId) {
		EntityManager em = emf.createEntityManager();
		
		try {			
			return em.find(Ansatt.class, ansattId);
		} finally {
			em.close();
		}
	}

	// Utlisting av alle ansatte 
	public List<Ansatt> finnAlleAnsatte() {
		EntityManager em = emf.createEntityManager();
		
		List<Ansatt> ansatte = null;
		
		try {
			String queryString = "SELECT a FROM Ansatt a ORDER BY a.ansattId";
			TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
			ansatte = query.getResultList();
			return ansatte;
		} finally {
			em.close();
		}
	}
	
	// Oppdatere en ansatt sin stilling og/eller lønn
	public void oppdaterStillingOgLonn(int ansattId, String nyStilling, int lonn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Ansatt oppdatertAnsatt = em.find(Ansatt.class, ansattId);
			oppdatertAnsatt.setStilling(nyStilling);
			oppdatertAnsatt.setMaanedslonn(lonn);
			
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	// Legge inn en ny ansatt 
	public Ansatt registrerNyAnsatt(Ansatt nyAnsatt) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Ansatt ansatt = null;
		
		try {
			tx.begin();
			
			// Lager ansattobjekt
			ansatt = nyAnsatt;
			
			em.persist(ansatt);
			System.out.println("Ny ansatt lagt til!");
			
			tx.commit();
		} finally {
			em.close();
		}
		
		return ansatt;
	}

}
