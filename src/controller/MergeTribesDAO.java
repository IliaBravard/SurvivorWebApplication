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
import model.MergeTribes;

public class MergeTribesDAO {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SurvivorWebApplication");

	/**
	 * This method inserts a merge tribe record to the "mtribes" table.
	 * 
	 * @param tribe - the tribe to be inserted in the table
	 */
	public void insertMergeTribe(MergeTribes tribe) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(tribe);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * This method searches for a particular marge tribe record from the "mtribes"
	 * table and deletes it permanently from the database.
	 * 
	 * @param tribe - the merge tribe record to be removed from the table
	 */
	public void deleteMergeTribe(MergeTribes tribe) {
		// To avoid magic numbers
		final int ONE_RESULT = 1;

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Using a parameterized query for additional protection
		TypedQuery<MergeTribes> typedQuery = em.createQuery(
				"SELECT	t from MergeTribes t WHERE t.tribeName = :selectedTribeName", MergeTribes.class);

		// Defining the parameters
		typedQuery.setParameter("selectedTribeName", tribe.getTribeName());

		// Getting only a single merge tribe/record to be removed
		typedQuery.setMaxResults(ONE_RESULT);

		// Saving the found record as a new object
		MergeTribes toDelete = typedQuery.getSingleResult();

		// Persisting and removing the object/record
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * This method traverses the "mtribes" table's records and adds them to a
	 * generic list.
	 * 
	 * @return a list populated with all existing tribe records in the table
	 */
	public List<MergeTribes> showAllTribes() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked") // Suppresses the warning for the JPQL statement
		List<MergeTribes> allTribes = em.createQuery("SELECT mt FROM MergeTribes mt").getResultList();
		return allTribes;
	}

	/**
	 * This method finds a tribe record from the "mtribes" table by using the
	 * primary key of each row as the search parameter.
	 * 
	 * @param tribe - the ID number of each record
	 * @return the found tribe record in the table
	 */
	public MergeTribes findTribe(int tribe) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Finding the merge tribe to be updated by its ID number
		MergeTribes toEditOrDelete = em.find(MergeTribes.class, tribe);
		em.close();
		return toEditOrDelete;
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