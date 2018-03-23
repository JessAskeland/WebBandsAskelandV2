package controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Band;

public class bandsHelper {

	static Scanner in = new Scanner(System.in);
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBandsAskeland");
	
	public void insertBands(Band toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Band toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Band> typedQuery = em.createQuery("select li from Band li where li.bandId = :selectedBandId", Band.class);
		typedQuery.setParameter("selectedBandId",  toDelete.getBandId());
		typedQuery.setMaxResults(1);
		Band result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Band> showAllBands() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Band> allResults = em.createQuery("Select li from Band li", Band.class);
		List<Band> allItems = allResults.getResultList();
		em.close();
		
		return allItems;
	}
	
	public Band searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Band foundItem = em.find(Band.class, idToEdit);
		em.close();
		return foundItem;
	}
	
	public void updateNameOfBand(Band toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Band> searchForNameOfBand(String nameOfBand) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Band> typedQuery = em.createQuery("select li from Band li where li.nameOfBand = :selectedNameOfBand", Band.class);
		typedQuery.setParameter("selectedNameOfBand", nameOfBand);
		List<Band> result = typedQuery.getResultList();
		em.close();
		return result;
	}
	
	public List<Band> searchForLevelOfBand(String levelOfBand) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Band> typedQuery = em.createQuery("select li from Band li where li.levelOfBand = :selectedLevelOfBand", Band.class);
		typedQuery.setParameter("selectedNameOfBand", levelOfBand);
		List<Band> result = typedQuery.getResultList();
		em.close();
		return result;
	}
	
	public List<Band> searchForLocationOfBand(String locationOfBand) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Band> typedQuery = em.createQuery("select li from Band li where li.locationOfBand = :selectedLocationOfBand", Band.class);
		typedQuery.setParameter("selectedLocationOfBand", locationOfBand);
		List<Band> result = typedQuery.getResultList();
		em.close();
		return result;
	}
	
	public void updateBands(Band toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
}
	