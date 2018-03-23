package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Band;
import model.pepBand;

public class pepBandHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBandsAskeland");

	public void insertPepBand(pepBand toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public void delete(pepBand toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<pepBand> typedQuery = em.createQuery("select li from pepBand li where li.bandId = :selectedBandId", pepBand.class);
		typedQuery.setParameter("selectedBandId",  toDelete.getBandId());
		typedQuery.setMaxResults(1);
		Band result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<pepBand> showAllBands() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<pepBand> allResults = em.createQuery("Select li from pepBand li", pepBand.class);
		List<pepBand> allItems = allResults.getResultList();
		em.close();
		
		return allItems;
	}
	
	public pepBand searchForPlayingPosition(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		pepBand foundItems = em.find(pepBand.class, idToEdit);
		em.close();
		return foundItems;
	}

	public void updatePlayingPosition(pepBand toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateBands(pepBand toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<pepBand> searchForPlayingPosition(String playingPosition) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<pepBand> typedQuery = em.createQuery("select li from pepBand li where li.playingPosition = :selectedPlayingPosition", pepBand.class);
		typedQuery.setParameter("selectedPlayingPosition", playingPosition);
		List<pepBand> result = typedQuery.getResultList();
		em.close();
		return result;
	}
	
	public pepBand searchForBandById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		pepBand foundItem =  em.find(pepBand.class, idToEdit);
		em.close();
		return foundItem;
	}
}
