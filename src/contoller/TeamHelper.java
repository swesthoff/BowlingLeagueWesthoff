package contoller;


//Sheri Westhoff
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Team;

public class TeamHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueWesthoff");

	public void insertItem(Team toAdd) {
		// TODO Auto-generated method stub

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}
}
