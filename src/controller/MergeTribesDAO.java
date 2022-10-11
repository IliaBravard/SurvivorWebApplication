package controller;

import java.util.List;

import javax.persistence.EntityManager;

// The package where this DAO is located at

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Provides access to the "MergeTRibes" entity
import model.MergeTribes;

public class MergeTribesDAO {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SurvivorWebApplication");

	/**
	 * This method inserts a merge tribe record to the "mtribes" table.
	 * 
	 * @param player - the player to be inserted in the table
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
	public void deleteMergeTribe(int mTribeId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		MergeTribes toDelete = em.find(MergeTribes.class, mTribeId);

		// Persist and remove the object/record
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * This method traverses the "mtribes" table's records and adds them to a
	 * generic list.
	 * 
	 * @return a list populated with all existing records in the table
	 */
	public List<MergeTribes> showAllTribes() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked") // Suppresses the warning for the JPQL statement
		List<MergeTribes> allTribes = em.createQuery("SELECT mt FROM MergeTribes mt").getResultList();
		return allTribes;
	}

	/**
	 * This method closes the entity manager factory as well as any connections
	 * inititated to the local database.
	 */
	public void cleanUp() {
		emfactory.close();
	}
}
