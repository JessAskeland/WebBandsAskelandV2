package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Competition;

public class competitionHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBandsAskeland");

	public void insertCompetition(Competition toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}
	
	public List<Competition> showAllCompetitions() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Competition> allResults = em.createQuery("Select list_item from Competition list_item", Competition.class);
		List<Competition> allCompetitions = allResults.getResultList();
		em.close();
		return allCompetitions;
	}
}
