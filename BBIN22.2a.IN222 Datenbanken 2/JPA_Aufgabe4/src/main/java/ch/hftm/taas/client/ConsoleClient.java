package ch.hftm.taas.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ch.hftm.taas.entities.Spiel;
import ch.hftm.taas.entities.Spieler;
import ch.hftm.taas.entities.Team;

public class ConsoleClient {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ch.hftm.db2.taas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

		// TEILAUFGABE A
		// -------------
		
		// Zürich erzeugen
		Team team1 = new Team();
		team1.setName("FC Zürich");
		team1.setPunkte(0);
		em.persist(team1);
		System.out.println("ID FC Zürich: " + team1.getId());
		
		// Madrid erzeugen
		Team team2 = new Team();
		team2.setName("Real Madrid");
		em.persist(team2);
		System.out.println("ID Real: " + team2.getId());
		
		// Spielpaarung
		Spiel spiel1 = new Spiel();
		spiel1.setTeam1(team1);
		spiel1.setTeam2(team2);
		spiel1.setToreTeam1(5);
		spiel1.setToreTeam2(0);
		em.persist(spiel1);

		// TEILAUFGABE B
		// -------------
		
		// Aufsuchen und ändern eines Teams
		Team teamMitId1 = em.find(Team.class, 1);
		teamMitId1.setPunkte(3);
		System.out.println("Punkte FC Zürich: " + teamMitId1.getPunkte());

		// TEILAUFGABE C
		// -------------
		
		// Tabelle ausgeben
		TypedQuery<Team> query = em
				.createQuery("select t from Team t order by t.punkte desc", Team.class);
		List<Team> rangliste = query.getResultList();
		int rang = 0;
		for (Team team : rangliste) {
			rang++;
			System.out.println(rang + ". " + team.getName() + "(" + team.getPunkte() + ")");
		}

		// WEITERE BEISPIELE
		// -----------------
		
		// Spieler aufnehmen
		for (int i = 1; i < 12; i++) {
			Spieler s = new Spieler();
			s.setName("Spieler " + i);
			s.setSalaer(10000*i);
			s.setTeam(teamMitId1);
			em.persist(s);
		}

		// Session übernehmen, Team aktualisieren und Spieler prüfen
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.refresh(teamMitId1);
		System.out.println("\nSpieler Team 1:");
		System.out.println("---------------");
		for (Spieler spieler : teamMitId1.getSpieler()) {
			System.out.println(spieler.getName());
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
