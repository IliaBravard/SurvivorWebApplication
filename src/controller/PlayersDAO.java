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
import model.Players;

public class PlayersDAO {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SurvivorWebApplication");

	/**
	 * This method inserts a player record to the "players" table.
	 * 
	 * @param player - the player to be inserted in the table
	 */
	public void insertPlayer(Players player) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(player);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * This method traverses the "players" table's records and adds them to a
	 * generic list.
	 * 
	 * @return a list populated with all existing player records in the table
	 */
	public List<Players> showAllPlayers() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked") // Suppresses the warning for the JPQL statement
		List<Players> allPlayers = em.createQuery("SELECT p FROM Players p").getResultList();
		return allPlayers;
	}

	/**
	 * This method searches for a particular player record from the "players" table
	 * and deletes it permanently from the database.
	 * 
	 * @param player - the player record to be removed from the table
	 */
	public void deletePlayer(Players player) {
		// To avoid magic numbers
		final int ONE_RESULT = 1;

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Using a parameterized query for additional protection
		TypedQuery<Players> typedQuery = em.createQuery(
				"SELECT	p from Players p WHERE p.firstName = :selectedFirstName	AND	p.lastName = :selectedLastName",
				Players.class);

		// Defining the parameters
		typedQuery.setParameter("selectedFirstName", player.getFirstName());
		typedQuery.setParameter("selectedLastName", player.getLastName());

		// Getting only a single player/record to be removed
		typedQuery.setMaxResults(ONE_RESULT);

		// Saving the found record as a new object
		Players toDelete = typedQuery.getSingleResult();

		// Persisting and removing the object/record
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * This method finds a player record from the "players" table by using the
	 * primary key of each row as the search parameter.
	 * 
	 * @param player - the ID number of each record
	 * @return the found player record in the table
	 */
	public Players findPlayer(int player) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Finding the player to be updated by its ID number
		Players toEdit = em.find(Players.class, player);
		em.close();
		return toEdit;
	}

	/**
	 * This method updates a player record from the "players" table.
	 * 
	 * @param toEdit - the player record to be updated from the table
	 */
	public void updatePlayer(Players toEdit) {
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
		if (emfactory.isOpen()) {
			emfactory.close();
		}
	}
}