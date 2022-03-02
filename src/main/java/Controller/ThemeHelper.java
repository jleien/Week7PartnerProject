/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Mar 2, 2022
**/
package Controller;

/**
 * @author jake
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.LegoTheme;



/**
 * @author jake
 *
 */
public class ThemeHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week7");

	public void insertNewTheme(LegoTheme t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<LegoTheme> showAllThemes(){
		EntityManager em = emfactory.createEntityManager();
		List<LegoTheme> allDetails = em.createQuery("SELECT t FROM LegoTheme t").getResultList();
		return allDetails;
	}

	public LegoTheme searchForThemeById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		LegoTheme found = em.find(LegoTheme.class, tempId);
		em.close();
		return found;
	}

	public void deleteTheme(LegoTheme themeToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LegoTheme> typedQuery = em.createQuery("SELECT l from LegoTheme l where l.id= :selectedId", LegoTheme.class);
		typedQuery.setParameter("selectedId", themeToDelete.getID());
		
		typedQuery.setMaxResults(1);
		
		LegoTheme result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateTheme(LegoTheme toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}