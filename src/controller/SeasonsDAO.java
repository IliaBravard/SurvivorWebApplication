package controller; // The package where this DAO class is located at

/**
 * @author Ilia Bravard - igbravard
 * CIS175 - Fall 2022
 * Oct 20, 2022
 */

// Including the needed imports
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

// Allows access to the specified entity
import model.Seasons;

public class SeasonsDAO {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SurvivorWebApplication");

	/**
	 * This method inserts a season record to the "seasons" table.
	 * 
	 * @param season - the season to be inserted in the table
	 */
	public void insertSeason(Seasons season) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(season);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * This method traverses the "seasons" table's records and adds them to a
	 * generic list.
	 * 
	 * @return a list populated with all existing season records in the table
	 */
	public List<Seasons> showAllSeasons() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked") // Suppresses the warning for the JPQL statement
		List<Seasons> allSeasons = em.createQuery("SELECT s FROM Seasons s").getResultList();
		return allSeasons;
	}

	/**
	 * This method searches for a particular season record from the "seasons" table
	 * and deletes it permanently from the database.
	 * 
	 * @param season - the season record to be removed from the table
	 */
	public void deleteSeason(Seasons season) {
		// To avoid magic numbers
		final int ONE_RESULT = 1;

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Using a parameterized query for additional protection
		TypedQuery<Seasons> typedQuery = em
				.createQuery("SELECT	s from Seasons s WHERE s.seasonNum = :selectedSeasonNum", Seasons.class);

		// Defining the parameters
		typedQuery.setParameter("selectedSeasonNum", season.getSeasonNum());

		// Getting only a single season/record to be removed
		typedQuery.setMaxResults(ONE_RESULT);

		// Saving the found record as a new object
		Seasons toDelete = typedQuery.getSingleResult();

		// Persisting and removing the object/record
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * This method finds a season record from the "seasons" table by using the
	 * primary key of each row as the search parameter.
	 * 
	 * @param season - the ID number of each record
	 * @return the found season record in the table
	 */
	public Seasons findSeason(int season) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Finding the season to be updated by its ID number
		Seasons toEditOrDelete = em.find(Seasons.class, season);
		em.close();
		return toEditOrDelete;
	}

	/**
	 * This method updates a season record from the "seasons" table.
	 * 
	 * @param toEdit - the season record to be updated from the table
	 */
	public void updateSeason(Seasons toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Merging allows for changing entity properties
		em.merge(toEdit);

		em.getTransaction().commit();
		em.close();
	}

	/**
	 * This method closes the entity manager factory as well as any connections
	 * initiated to the local database, if any.
	 */
	public void cleanUp() {
		if(emfactory.isOpen()) {
			emfactory.close();
		}
	}
}