package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Provides access to the "Seasons" entity
import model.Seasons;

public class SeasonsDAO {
	
	// Creating a global instance of the entity manager factory to be used for database transations
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SurvivorWebApplication");
	
	/**
	 * This method inserts a season record to the "seasons" table.
	 * @param s - the season to be inserted in the table
	 */
	public void insertSeason(Seasons s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List showSeasons() {
		
	}
}
