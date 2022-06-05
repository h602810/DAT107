package dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Avdeling;

public class AvdelingDAO {
private EntityManagerFactory emf;
	
	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("oblig3",
				Map.of("javax.persistence.jdbc.password", "Yeet1234"));
	}
	
	/*------------------------------------------------------------------*/

	// 
	public Avdeling finnAvdelingMedId(int avdelingsId) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Avdeling.class, avdelingsId);
		} finally {
			em.close();
		}
	}
}
