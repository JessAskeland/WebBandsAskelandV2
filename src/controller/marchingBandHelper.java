package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Band;
import model.marchingBand;

public class marchingBandHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBandsAskeland");
	
	public void insertMarchingBand(marchingBand toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(marchingBand toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<marchingBand> typedQuery = em.createQuery("select li from marchingBand li where li.bandId = :selectedId", marchingBand.class);
		typedQuery.setParameter("selectedId", toDelete.getBandId());
		typedQuery.setMaxResults(1);
		Band result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}
	
	public List<marchingBand> showAllBands() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<marchingBand> allResults = em.createQuery("Select li from marchingBand li", marchingBand.class);
		List<marchingBand> allItems = allResults.getResultList();
		em.close();
		
		return allItems;
	}
	
	public marchingBand searchForTypesOfProps(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		marchingBand foundItems = em.find(marchingBand.class, idToEdit);
		em.close();
		return foundItems;
	}
	
	public void updateTypesOfProps(marchingBand toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateBands(marchingBand toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<marchingBand> searchForTypesOfProps(String typeOfProps) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<marchingBand> typedQuery = em.createQuery("select li from marchingBand li where li.typesOfProps = :selectedTypesOfProps", marchingBand.class);
		typedQuery.setParameter("selectedTypeOfProps", typeOfProps);
		List<marchingBand> result = typedQuery.getResultList();
		em.close();
		return result;
	}
	
	public marchingBand searchForBandById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		marchingBand foundItem = em.find(marchingBand.class, idToEdit);
		em.close();
		return foundItem;
	}

		
}
