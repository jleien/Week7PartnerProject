package Controller;
/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Mar 2, 2022
**/
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.LegoSet;



public class SetHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week7PartnerProject");

	public void insertLegoSet(LegoSet sl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(sl);
		em.getTransaction().commit();
		em.close();
	}

	public List<LegoSet> showAllLegoSets() {
		EntityManager em = emfactory.createEntityManager();
		List<LegoSet> allItems = em.createQuery("SELECT i FROM LegoSet i").getResultList();
		return allItems;

	}

	public void deleteLegoSet(LegoSet toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LegoSet> typedQuery = em.createQuery(
				"SELECT ls FROM LegoSet ls WHERE ls.setName = :selectedName AND ls.numPieces = :selectedNumPieces", LegoSet.class);
		typedQuery.setParameter("selectedName", toDelete.getSetName());
		typedQuery.setParameter("selectedNumPieces", toDelete.getNumPieces());

		typedQuery.setMaxResults(1);
		LegoSet result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public LegoSet searchForLegoSetById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		LegoSet found = em.find(LegoSet.class, idToEdit);
		em.close();
		return found;
	}

	public void updateLegoSet(LegoSet toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<LegoSet> searchForLegoSetByName(String setName) {
//			TODO	Auto-generated	method	stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LegoSet> typedQuery = em.createQuery("select ls from LegoSet ls where ls.name=:selectedName", LegoSet.class);
		typedQuery.setParameter("selectedName", setName);

		List<LegoSet> foundItems = typedQuery.getResultList();
		em.close();

		return foundItems;
	}

	public List<LegoSet> searchForLegoSetByNumPieces(String numPieces) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LegoSet> typedQuery = em.createQuery("select ls from LegoSet ls where ls.numPieces=:selectedNumPieces", LegoSet.class);
		typedQuery.setParameter("selectedNumPieces", numPieces);

		List<LegoSet> foundItems = typedQuery.getResultList();
		em.close();

		return foundItems;
	}
	
	public List<LegoSet> searchForLegoSetByPrice(String price) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LegoSet> typedQuery = em.createQuery("select ls from LegoSet ls where ls.price=:selectedPrice", LegoSet.class);
		typedQuery.setParameter("selectedPrice", price);

		List<LegoSet> foundItems = typedQuery.getResultList();
		em.close();

		return foundItems;
	}
	
	public List<LegoSet> searchForLegoSetByDimensions(String dimensions) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LegoSet> typedQuery = em.createQuery("select ls from LegoSet ls where ls.dimensions=:selectedDimensions", LegoSet.class);
		typedQuery.setParameter("selectedDimensions", dimensions);

		List<LegoSet> foundItems = typedQuery.getResultList();
		em.close();

		return foundItems;
	}

	public void cleanUp() {
		emfactory.close();
	}
}