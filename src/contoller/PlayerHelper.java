package contoller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;
import model.Team;

public class PlayerHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueWesthoff");

	public void insertPlayer(Player toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public void deletePlayer(Player toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select p from Player p where p.playerId = :selectedId",
				Player.class);
		typedQuery.setParameter("selectedId", toDelete.getPlayerId());
		typedQuery.setMaxResults(1);
		Player result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Player searchForPlayerById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		Player foundPlayer = em.find(Player.class, idToEdit);
		em.close(); // close
		// return the results of the query
		return foundPlayer;
	}

	public List<Player> showAllPlayers() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Player> allResults = em.createQuery("select t from Player t", Player.class);
		List<Player> allPlayers = allResults.getResultList();
		em.close();
		return allPlayers;
	}

	public void deleteAllPlayersOnTeam(Team teamToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> deleteAllPlayers = em.createQuery("delete from Player pl where pl.team = :teamToDelete",
				Player.class);
		deleteAllPlayers.setParameter("teamToDelete", teamToDelete);
		int deleteCount = deleteAllPlayers.executeUpdate();
		if (deleteCount> 0) {
			System.out.println("All Players were deleted for the team");
		}else {
			System.out.println("No players for for selected team");
		}

		em.getTransaction().commit();
		em.close();
	}

	// public Team findTeamByName(String teamName) {
	// try {
	// EntityManager em = emfactory.createEntityManager();
	// TypedQuery<Team> findTeam = em.createQuery("select t from Team t where
	// t.teamName = :selectedName", Team.class);
	// findTeam.setParameter("selectedName", teamName);
	// findTeam.setMaxResults(1);
	// Team foundTeam = findTeam.getSingleResult();
	// em.close();
	// return foundTeam;
	// } catch(NoResultException e){
	// return null;
	// }
}
