package utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class utility{
static EntityManagerFactory emf = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("finease-connect");
	}
	
	public static EntityManager getEm() {
		return emf.createEntityManager();
	}
}