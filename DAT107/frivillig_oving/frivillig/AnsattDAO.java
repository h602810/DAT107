package no.hvl.dat107.frivillig;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AnsattDAO {
	private EntityManagerFactory emf;
	
	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("ansattPU",
				Map.of("javax.persistence.jdbc.password", "Yeet1234"));
	}
	
    /* --------------------------------------------------------------------- */

	public Ansatt hentAnsattForBrukernavn(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Ansatt.class, brukernavn);
		} finally {
			em.close();
		}
	}
}
